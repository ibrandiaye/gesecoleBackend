package tp.ibra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tp.ibra.entities.Niveau;
import tp.ibra.entities.TypeEvaluation;
import tp.ibra.repository.NiveauRepository;
import tp.ibra.repository.TypeEvaluationRepository;

@SpringBootApplication
public class GesecoleApplication implements CommandLineRunner{
	
	@Autowired
	private NiveauRepository niveauRepository;
	@Autowired
	private TypeEvaluationRepository typeEvaluationRepository;

	public static void main(String[] args) {
		SpringApplication.run(GesecoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Niveau n1 = new Niveau(0,"Moyen",null);
		Niveau n2 = new Niveau(0,"Secondaire",null);
		TypeEvaluation typeEvaluation1 = new TypeEvaluation(0, "Devoir");
		TypeEvaluation typeEvaluation2 = new TypeEvaluation(0, "Composition");
		niveauRepository.save(n1);
		niveauRepository.save(n2);
		typeEvaluationRepository.save(typeEvaluation1);
		typeEvaluationRepository.save(typeEvaluation2);
	}
}
