package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Lesson;
import entitites.Task;
import entitites.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aula tem o curso? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("\nDados da %dª aula: \n", i + 1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);

			while (type != 'c' && type != 't') {
				System.out.println("INVALID VALUE! Type c or t!");
				System.out.print("Conteúdo ou tarefa (c/t)? ");
				type = sc.next().charAt(0);
			}

			System.out.print("Título: ");
			sc.nextLine();
			String name = sc.nextLine();

			switch (type) {
			case 'c':

				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				list.add(new Video(name, url, duration));
				break;

			case 't':
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionsNumber = sc.nextInt();
				list.add(new Task(description, description, questionsNumber));
				break;
			}
		}

		int totalDuration = 0;
		for (Lesson listLesson : list) {
			totalDuration += listLesson.duration();
		}

		System.out.printf("\nDURAÇÃO TOTAL DO CURSO = %d segundos\n", totalDuration);
		sc.close();
	}

}
