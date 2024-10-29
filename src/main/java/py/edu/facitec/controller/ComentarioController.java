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

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;


@RestController
@RequestMapping("/api")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping("/comentarios")
public ResponseEntity<List<Comentario>> getComentarios(){
		
	List<Comentario> comentarios=new ArrayList<>();
								//buscar todos
	comentarios =comentarioRepository.findAll();
	
return new ResponseEntity<List<Comentario>>(comentarios, HttpStatus.OK);
	
	
	}
	//Post se utiliza para crear un elemento.
	@PostMapping("/comentario")
	public ResponseEntity<Comentario> 
		//JSON --> JAVA
guardarComentario(@RequestBody Comentario comentario){
		
		
		comentarioRepository.save(comentario);
		
		
return new ResponseEntity
		//Devolver el objeto nuevo creado
		//id nuevo
		<Comentario>(comentario, HttpStatus.OK);		
		
	}
	
	//Consulta api/comentario/{codigo}
	//buscar un comentario por codigo

@GetMapping("/comentario/{codigo}")	
public ResponseEntity<Comentario> 
				//Recibir por parametro el valor
getOneComentario(@PathVariable Long codigo){
	
Optional<Comentario> comentario=
comentarioRepository.findById(codigo);
		//comparar si se encontro
if(comentario.isPresent()) {
return new ResponseEntity<Comentario>
			(comentario.get(), HttpStatus.OK);
}else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
}

}

	//api/comentario/codigo
	//Eliminar un comentario por codigo   Delete
@DeleteMapping("/comentario/{codigo}")	
public ResponseEntity<Comentario> 
eliminarOneComentario(@PathVariable Long codigo){
	
Optional<Comentario> comentario=
comentarioRepository.findById(codigo);
		//comparar si se encontro
if(comentario.isPresent()) {
		//elimina un comentario
	comentarioRepository.deleteById(codigo);

		return new ResponseEntity<>
			(HttpStatus.NO_CONTENT);
}else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
}


	
	
	
}
	
	
	
}
