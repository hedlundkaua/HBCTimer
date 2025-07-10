package com.HBCTimerAPI.domain.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_study_session")
public class StudySession {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private LocalDate date;
	
	@Column(name = "total_time_of_day")
	private Long totalTimeOfDay = 0L;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;
	
	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudyTracker> items = new ArrayList<>();
	
	public StudySession() {
		
	}

	public StudySession(LocalDate date, Long totalTimeDate, User student) {
		super();
		this.date = date;
		this.totalTimeOfDay = totalTimeDate;
		this.student = student;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTotalTimeOfDay(Long totalTimeOfDay) {
		this.totalTimeOfDay = totalTimeOfDay;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}

	public Duration getTotalTimeOfDay() {
		//operador ternario para fazer se totalTimeOfDay for diferente de null, 
		//ele executa oque vem antes dos : se for nullo ele executa oque vem depois
		return totalTimeOfDay != null ? Duration.ofSeconds(totalTimeOfDay) : Duration.ZERO;
	}

	public User getStudent() {
		return student;
	}
	
	public List<StudyTracker> getItems() {
		return items;
	}

	public void setTotalTimeOfDay(Duration duration) {
		//pega o duration e verifica se for diferente de null ele faz o duration que vem de parametro e converte para segundos 
		//e guarda no atributo do tipo long assim convertendo de Duration para long
		this.totalTimeOfDay = duration != null ? duration.getSeconds() : 0L;
	}
	
	public void addTracker(StudyTracker tracker) {
	    items.add(tracker); //adiciona o tracker na lista de items
	    Duration currentTotal = getTotalTimeOfDay(); //converte long para duration
	    Duration trackerDuration = tracker.getTotalTime(); //pega o resultado do tempo estudado e guarda em trackerDuration
	    //pegaa conversão do totaltimeofday que agora é duration e soma(plus) com a operação se trakcerDuration for diferente de null
	    // pega o trackerDuration e soma(plus) em currentTotal que é a conversão do totaltimeofday para Duration e caso trakcerDuration
	    //for null ele soma 0 em currentTotal. Apos isso guarda em newTotal
	    Duration newTotal = currentTotal.plus(trackerDuration != null ? trackerDuration : Duration.ZERO); 
	    setTotalTimeOfDay(newTotal); // seta o newTotal com o metodo de set que converte o newtotal do tipo
	    //Duration para Long 
	}

	public void updateTotalTimeOfDay() {
	    Duration total = items.stream()// cria uma stream com a lista de items(Lista de StudyTrackers)
	        .map(StudyTracker::getTotalTime) //para cada StudyTracker ele pega o getTotalTime -> que por sua vez calcula os blocos de estudos iniciados.
	        .filter(Objects::nonNull) // filtra para remover qualquer ocorrencia null da lista
	        .reduce(Duration.ZERO, Duration::plus); // como nosso metodo getTotalTime retorna Duration, podemos fazer
	    //a soma dos getTotalTime começando por Duration.ZERO e ir somando esses getTotalTime
	    setTotalTimeOfDay(total); // por fim convertemos nosso total do tipo Duration para Long com o metodo setTotalTimeOfDay.
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudySession other = (StudySession) obj;
		return Objects.equals(id, other.id);
	}
}
