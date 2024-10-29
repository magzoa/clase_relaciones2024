package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;


@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
public ResponseEntity<List<Post>> getPosts(){
		
	List<Post> posts=new ArrayList<>();
								//buscar todos
	posts =postRepository.findAll();
	
return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	
	
	}
	
	@PostMapping("/post")
	public ResponseEntity<Post> 
		
guardarPost(@RequestBody Post post){
		
		
		postRepository.save(post);
		
		
return new ResponseEntity
	
		<Post>(post, HttpStatus.OK);		
		
	}
	
	
@GetMapping("/post/{codigo}")	
public ResponseEntity<Post> 
				
getOnePost(@PathVariable Long codigo){
	
Optional<Post> post=
postRepository.findById(codigo);
		//comparar si se encontro
if(post.isPresent()) {
return new ResponseEntity<Post>
			(post.get(), HttpStatus.OK);
}else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
}

}

	//api/post/codigo
	//Eliminar un post por codigo   Delete
@DeleteMapping("/post/{codigo}")	
public ResponseEntity<Post> 
eliminarOnePost(@PathVariable Long codigo){
	
Optional<Post> post=
postRepository.findById(codigo);
		//comparar si se encontro
if(post.isPresent()) {
		//elimina un post
	postRepository.deleteById(codigo);

		return new ResponseEntity<>
			(HttpStatus.NO_CONTENT);
}else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
}


	
	
	
}
	
	
	
}
