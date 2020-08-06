package com.lti.model;

import java.util.ArrayList;
import java.util.List;

import com.lti.model.Question.Difficulty;

public class QuestionBankLoader {
	public List<Question> loadQuestionsOnJava() {
		String subjectName = "Java";
		QuestionBank qb = new QuestionBank();
		qb.addNewSubject(subjectName);
		
		Question q = new Question("What is JAVA?", Difficulty.EASY);
		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("Java is a Database", false));
		ops.add(new Option("Java is a Programming Language", true));
		ops.add(new Option("Java is an OS", false));
		ops.add(new Option("Java is a fileSystem", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		
		q = new Question("What is G1?", Difficulty.EASY);
		ops = new ArrayList<Option>();
		ops.add(new Option("G1 is a Garbage Collector in JAVA", true));
		ops.add(new Option("G1 is English Word for Jeevan", false));
		ops.add(new Option("G1 is the name of the spy agency", false));
		ops.add(new Option("G1 is the sequel of SRK's  Ra.One", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		return qb.getQuestionsFor(subjectName);
		
	}
}
