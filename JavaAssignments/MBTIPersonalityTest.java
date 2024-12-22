import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;




public class MBTIPersonalityTest {
	public static void main (String[] args)
	{
		String[][] sectionA = {{"A) Expend energy, enjoy groups","B) Conserve energy, enjoy one-on-one"},{"A) More Outgoing,think out loud","B) More reserved, think to yourself"},{"A) Seek many tasks, public activities, interaction with others","B) Seek private, solitary activities with quiet to concentrate"},{"A) External communicative, express yourself","B) Internal, reticent, Keep to yourself"},{"A) Active, initiate","B) Reflective, deliberated"}};
		String[][] sectionB = {{"A) Interpret literally","Look for meaning and possibilities"},{"A) Pratical, realistic, experiential","B) Imaginative, innovative, theoretical"},{"A) Standard, usual, conventional","B) Different, novel, unique"},{"A) Focus on here-and-now","B) Look to the future, global perpespective, big picture"},{"A) Facts, things, what is","B) Ideas, dreams, what could be, philosophical"}};
		String[][] sectionC = {{"A) Logical, thinking, questioning","B) Emphatic, feeling, accomodating"},{"A) Candid, straight forward, frank","B) Tactful, kind, encouraging"},{"A) Firm, tend to criticize, hold the line","B) Gentle, tend to appreciate, conciliate"},{"A) Tough minded, just","B) Tender hearted, merciful"},{"A) Matter of facts,issue-oriented","B) Sensitive, people-oriented, compassionate"}};
		String[][] sectionD = {{"A) Organized, orderly","B) Flexible, adaptable"},{"A) Plan, schedule","B) Unplanned, spontaneous"},{"A) Regulated, structured","B) Easy going, live and let live"},{"A) Preparation, plan ahead","B) Go with the flow, adapt as you go"},{"A) Control, govern","B) Latitude, freedom"}};

		ArrayList<String> sectionAAnswers = new ArrayList<>();
		ArrayList<String> sectionBAnswers = new ArrayList<>();
		ArrayList<String> sectionCAnswers = new ArrayList<>();
		ArrayList<String> sectionDAnswers = new ArrayList<>();

		String personalityType = "";
		int sectionACountA = 0;
		int sectionACountB = 0;
		int sectionBCountA = 0;
		int sectionBCountB = 0;	
		int sectionCCountA = 0;
		int sectionCCountB = 0;
		int sectionDCountA = 0;
		int sectionDCountB = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to MBTI Personality Test");
        	System.out.println("Please answer each question by selecting A or B");

		for (int i = 0; i < sectionA.length; i++)
		{	
			boolean validAnswer = false;
			while (!validAnswer) {	
				System.out.println(sectionA[i][0]);
				System.out.println(sectionA[i][1]);
				System.out.println("Please select A or B");
				System.out.print(">>>>>>>>>>>  ");
				String response = input.next().toUpperCase();
				
				char answer = response.charAt(0);

				if (answer == 'A')
				{
					sectionACountA++;
					sectionAAnswers.add(sectionA[i][0]);
					validAnswer = true;
					
				} else if (answer == 'B')
				{
					sectionACountB++;
					sectionAAnswers.add(sectionA[i][1]);
					validAnswer = true;

				} else {
					System.out.println("Please enter either A or B");			
				}
			}
		}
		personalityType += sectionACountA > sectionACountB ? "E" : "I";
		for (int i = 0; i < sectionB.length; i++)
		{	
			boolean validAnswer = false;
			while (!validAnswer) {	
				System.out.println(sectionB[i][0]);
				System.out.println(sectionB[i][1]);
				System.out.println("Please select A or B");
				System.out.print(">>>>>>>>>>>  ");
				String response = input.next().toUpperCase();
				
				char answer = response.charAt(0);


				if (answer == 'A')
				{
					sectionBCountA++;
					sectionBAnswers.add(sectionB[i][0]);
					validAnswer = true;
					
				} else if (answer == 'B')
				{
					sectionBCountB++;
					sectionBAnswers.add(sectionB[i][1]);
					validAnswer = true;

				} else {
					System.out.println("Please enter either A or B");			
				}

				
			}
	
		}
		personalityType += sectionBCountA > sectionBCountB ? "S" : "N";
		for (int i = 0; i < sectionC.length; i++)
		{	
			boolean validAnswer = false;
			while (!validAnswer) {	
				System.out.println(sectionC[i][0]);
				System.out.println(sectionC[i][1]);
				System.out.println("Please select A or B");
				System.out.print(">>>>>>>>>>>  ");
				String response = input.next().toUpperCase();
				
				char answer = response.charAt(0);

				if (answer == 'A')
				{
					sectionCCountA++;
					sectionCAnswers.add(sectionC[i][0]);
					validAnswer = true;
					
				} else if (answer == 'B')
				{
					sectionCCountB++;
					sectionCAnswers.add(sectionC[i][1]);
					validAnswer = true;

				} else {
					System.out.println("Please enter either A or B");			
				}

			}
		}
		personalityType += sectionCCountA > sectionCCountB ? "T" : "F";
		for (int i = 0; i < sectionD.length; i++)
		{	
			boolean validAnswer = false;
			while (!validAnswer) {	
				System.out.println(sectionD[i][0]);
				System.out.println(sectionD[i][1]);
				System.out.println("Please select A or B");
				System.out.print(">>>>>>>>>>>  ");
				String response = input.next().toUpperCase();
				
				char answer = response.charAt(0);

				if (answer == 'A')
				{
					sectionDCountA++;
					sectionDAnswers.add(sectionD[i][0]);
					validAnswer = true;
					
				} else if (answer == 'B')
				{
					sectionDCountB++;
					sectionDAnswers.add(sectionD[i][1]);
					validAnswer = true;

				} else {
					System.out.println("Please enter eithe A or B");			
				}

			}
		}
		personalityType += sectionDCountA > sectionDCountB ? "J" : "P";
		


		System.out.println(personalityType);
		
		switch (personalityType) {
			case "ISTJ": 
				System.out.println("ISTJ\n Introverted, Sensing, Thinking, Judging\nIndividuals with ISTJ personality types are known for their practicality organization, and reliability. They value tradition and order, and are often drawn to careers in law enforcement, finance, and government. ISTJs are detail-oriented and analytical, making them excellent problem-solvers. They are also loyal and committed to their lov d ones, and value long-term relationships. However, ISTJs may struggle with adaptability and spontaneity, preferring routine and structure");
				break;


			case "ISFJ":
				System.out.println("ISFJ\nIntroverted, Sensing, Feeling, Judging\nISFJs are compassionate and supportive individuals who prioritize the needs of others. They are meticulous and organized, with a strong attention to detail. ISFJs excel in careers that involve helping others, such as teaching, nursing, and social work. They value harmony and stability, and are often peacemakers in their personal and professional lives. However, ISFJs may struggle with assertiveness and boundary-setting, and may need to work on expressing their own needs and desires");
				break;


			case "INFJ":
				System.out.println("INFJ\nIntroverted, Intuitive, Feeling, Judging\nINFJs are visionary and empathetic individuals who are driven to make a positive difference in the world. They are creative and innovative, with a strong connection to their intuition. INFJs excel in careers that involve helping others, such as counseling, teaching, and social justice. They value authenticity and integrity, and are often drawn to artistic or humanitarian pursuits. However, INFJs may struggle with burnout and self-care, and may need to prioritize their own needs");
		        	break;

			case "INTJ":
				System.out.println("INTJ\nIntroverted, Intuitive, Thinking, Judging\nINTJs are strategic and analytical individuals who are driven to achieve greatness. They are independent and self-motivated, with a strong desire for knowledge and understanding. INTJs excel in careers that involve innovation and problem-solving, such as science, technology, and entrepreneurship. They value efficiency and effectiveness, and are often drawn to leadership roles. However, INTJs may struggle with interpersonal relationships and emotional intelligence");
				break;


			case "ISTP":
				System.out.println("ISTP\nIntroverted, Sensing, Thinking, Perceiving\nISTPs are resourceful and adaptable individuals who thrive in dynamic environments. They are practical and hands-on, with a strong connection to the physical world. ISTPs excel in careers that involve troubleshooting and problem-solving, such as engineering, technology, and emergency response. They value freedom and flexibility, and are often drawn to unconventional lifestyles.");
		        	break;


			case "ISFP":
				System.out.println("ISFP\nIntroverted, Sensing, Feeling, Perceiving\nISFPs are artistic and compassionate individuals who value creativity and self-expression. They are gentle and empathetic, with a strong connection to the emotional realm. ISFPs excel in careers that involve art, music, and performance. They value authenticity and individuality, and are often drawn to alternative lifestyles");
				break;


			case "INFP":
				System.out.println("INFP\nIntroverted, Intuitive, Feeling, Perceiving\nINFPs are idealistic and creative individuals who are driven to make a positive difference in the world. They are empathetic and compassionate, with a strong connection to their intuition. INFPs excel in careers that involve writing, teaching, and social justice. They value authenticity and integrity, and are often drawn to artistic or humanitarian pursuits.");
				break;


			case "INTP":
				System.out.println("INTP\nIntroverted, Intuitive, Thinking, Perceiving\nINTPs are innovative and analytical individuals who are driven to understand the world around them. They are independent and self-motivated, with a strong desire for knowledge and understanding. INTPs excel in careers that involve science, technology, and philosophy. They value intellectual freedom and curiosity.");
				break;


			case "ESTP":
				System.out.println("ESTP\nExtroverted, Sensing, Thinking, Perceiving\nESTPs are adventurous and action-oriented individuals who thrive in dynamic environments. They are practical and hands-on, with a strong connection to the physical world. ESTPs excel in careers that involve sales, marketing, and entrepreneurship. They value freedom and flexibility");
				break;


			case "ESFP":
				System.out.println("ESFP\nExtroverted, Sensing, Feeling, Perceiving\nESFPs are spontaneous and enthusiastic individuals who value creativity and self-expression. They are social and outgoing, with a strong connection to the emotional realm. ESFPs excel in careers that involve entertainment, teaching, and event planning.");
				break;


			case "ENFP":
				System.out.println("ENFP\nExtroverted, Intuitive, Feeling, and Perceiving\n ENFPs are charismatic and imaginative individuals who inspire others with their creativity and passion. They are empathetic and compassionate, with a strong connection to their intuition. ENFPs excel in careers that involve writing, teaching, and social justice.");
				break;


			case "ENTP":
				System.out.println("ENTP\nExtroverted, Intuitive, Thinking, Perceiving\nENTPs are entrepreneurial and innovative individuals who are driven to revolutionize the status quo. They are independent and self-motivated, with a strong desire for knowledge and understanding. ENTPs excel in careers.");
				break;


			case "ESTJ":
				System.out.println("ESTJ\nExtraverted, Sensing, Thinking, Judging\nAs an ESTJ, you possess a unique blend of assertive leadership and practical expertise, making you a respected authority in your field. Your ability to bring order and stability to any organization is unparalleled, and your decisiveness and confidence inspire others to follow your lead. Your strong sense of responsibility and duty drives you to take charge and ensure that tasks are completed efficiently. You value tradition and structure, and your attention to detail is exceptional. With your natural charisma and leadership abilities, you excel in roles that require strategic planning and execution.");
				break;


			case "ESFJ":
				System.out.println("ESFJ\nExtraverted, Sensing, Feeling, Judging\nAs an ESFJ, you are a beloved community builder, renowned for your warmth and exceptional organizational skills. Your talent for bringing people together and fostering meaningful connections creates a positive impact on those around you. Your empathy and support nurture growth, and your dedication to helping others is unwavering. You excel in roles that involve teamwork, mediation, and conflict resolution. Your attention to detail and ability to multitask make you an invaluable asset in any organization.");
				break;


			case "ENFJ":
				System.out.println("ENFJ\nExtraverted, Intuitive, Feeling, Judging\nAs an ENFJ, you possess a rare combination of charismatic leadership and empathetic understanding. Your ability to inspire others to grow and develop is unparalleled, and your strategic vision motivates and guides those around you. Your unique blend of intuition and compassion enables you to navigate complex emotional landscapes with ease. You excel in roles that require coaching, mentoring, or counseling, and your natural charisma makes you a compelling public speakValue your exceptional interpersonal skills, and continue to harness your transformative power to make a positive impact.");
				break;


			case "ENTJ":
				System.out.println("ENTJ\nExtraverted, Intuitive, Thinking, Judging\nAs an ENTJ, you embody the spirit of confident leadership and strategic vision. Your entrepreneurial drive and innovative thinking propel you toward greatness, and your logical analysis uncovers innovative solutions. Your trailblazing nature and willingness to take calculated risks inspire others to follow your lead. You thrive in challenging environments, where your quick thinking and adaptability enable you to stay ahead of the curve.");
				break;

			default:
				System.out.println("invalid input");
				break;
		}
	}


}