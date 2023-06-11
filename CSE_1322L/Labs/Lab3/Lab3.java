import java.util.ArrayList;
import java.util.Scanner;
class Question{
    private String questionText;
    private String questionAnswer;
    private int questionDifficulty;

    Question(){
        this.questionText = "Sample Question";
        this.questionAnswer = "Sample Answer";
        this.questionDifficulty = 0;
    }
    Question(String questionText, String questionAnswer, int questionDifficulty){
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
        this.questionDifficulty = questionDifficulty;
    }

    String getQuestionText(){
        return this.questionText;
    }

    String getQuestionAnswer(){
        return this.questionAnswer;
    }

    int getQuestionDifficulty(){
        return this.questionDifficulty;
    }

    void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    void setQuestionAnswer(String questionAnswer){
        this.questionAnswer = questionAnswer;
    }

    void setQuestionDifficulty(int questionDifficulty){
        if(questionDifficulty < 1 || questionDifficulty > 3){
            System.out.println("Invalid difficulty.");
        }
        else{
            this.questionDifficulty = questionDifficulty;
        }
    }
}
class Quiz{
    ArrayList<Question> questions = new ArrayList<Question>();

    void add_question(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the question text?");
        String questionText = sc.nextLine();
        System.out.println("What is the answer?");
        String questionAnswer = sc.nextLine();
        System.out.println("How Difficult (1-3)?");
        int questionDifficulty = sc.nextInt();
        Question question = new Question(questionText, questionAnswer, questionDifficulty);
        questions.add(question);
    }

    void remove_question(){
        Scanner sc = new Scanner(System.in);
        for(Question i : questions){
            System.out.println(questions.indexOf(i) + ". " + i.getQuestionText());
        }
        System.out.println("Choose the question to remove?");
        int questionNumber = sc.nextInt();
        questions.remove(questionNumber);
    }

    void modifyQuestion(){
        Scanner sc = new Scanner(System.in);
        for(Question i : questions){
            System.out.println(questions.indexOf(i) + ". " + i.getQuestionText());
        }
        System.out.println("Choose the question to modify?");
        int questionNumber = sc.nextInt();
        System.out.println("What is the question text?");
        sc.nextLine();
        String questionText = sc.nextLine();
        System.out.println("What is the answer?");
        String questionAnswer = sc.nextLine();
        System.out.println("How Difficult (1-3)?");
        int questionDifficulty = sc.nextInt();
        Question question = new Question(questionText, questionAnswer, questionDifficulty);
        questions.set(questionNumber, question);
    }

    void giveQuiz(){
        Scanner sc = new Scanner(System.in);
        int score = 0;
        for(Question i : questions){
            System.out.println(i.getQuestionText());
            String answer = sc.nextLine();
            if(answer.equals(i.getQuestionAnswer())){
                System.out.println("Correct");
                score++;
            }
            else{
                System.out.println("Incorrect");
            }
        }
        System.out.println("You got " + score + " out of " + questions.size());
    }
}



public class Lab3 {
    
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();
        int choice = 0;
        do{
            System.out.println("What would you like to do?");
            System.out.println("1. Add a question to the quiz");
            System.out.println("2. Remove a question from the quiz");
            System.out.println("3. Modify a question in the quiz");
            System.out.println("4. Take the quiz");
            System.out.println("5. Quit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    quiz.add_question();
                    break;
                case 2:
                    quiz.remove_question();
                    break;
                case 3:
                    quiz.modifyQuestion();
                    break;
                case 4:
                    quiz.giveQuiz();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice, please enter a different integer.");
                    break;
            }
        }while(choice != 5);
    }
}

/*
Concept Summary:
1. ArrayLists and ArrayList methods
2. Classes
3. Methods
4. String methods
Objective:
In this lab, you’ll create a program which allows us to administer a quiz. A user will be able to
add questions, remove questions and modify questions. In addition, a user will be able to take a
quiz and get a score.
Classes:
You’ll be creating two classes. A Question Class and a Quiz Class.
Question class
Each object created from the Question Class will hold one question. Objects created from the
Question class should have the following attributes:
1. The question text (string)
2. The question answer (string)
3. Level of difficulty (integer 1-3, 1 being easy, 3 being difficult)
All attributes should be private, and there should be getters/setters for all attributes. It should
have a constructor that sets all 3 attributes.
Quiz class
The Quiz class must contain an arraylist or list of objects that should be created from the
Question Class. The Quiz class should have the following methods:
1. add_question() Method should prompt the user for a new question, answer and difficulty,
and then create a Question object with that data and add it to the arraylist/list.
2. remove_question() Method should present the user with a list of all the question texts,
and ask which one to remove. When the user indicates the question to remove, it should
remove that question from the arraylist/list.
3. modify_question() Method should present the user with a list of all the question texts, and
ask which one to change. Then it should prompt the user for the new question text, the
new question answer, and the new difficulty, and update the appropriate question in the
arraylist.
4. give_quiz() Method should present each question to the user, accept an answer (string)
for each question. It should then tell the user if they are correct or wrong (if the string the
user typed in exactly matches the correct answer stored in the question object they are
correct). Keep track of their score. At the end of the quiz, tell the user how many they
got correct.
Driver:
Your driver program should create an instance of Quiz, then present the user with a menu.
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
Keep presenting the same menu over and over until the user quits.
Sample Output:
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
1
What is the question Text?
What is the capital of Georgia?
What is the answer?
Atlanta
How Difficult (1-3)?
1
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
1
What is the question Text?
What is the name of the mascot for KSU?
What is the answer?
Scrappy
How Difficult (1-3)?
1
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
1
What is the question Text?
How many fingers does a typical human have?
What is the answer?
6
How Difficult (1-3)?
1
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
3
Choose the question to modify?
0. What is the capital of Georgia?
1. What is the name of the mascot for KSU?
2. How many fingers does a typical human have?
2
What is the question Text?
How many fingers does a typical human have?
What is the answer?
5
How Difficult (1-3)?
1
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
1
What is the question Text?
How many students does KSU have?
What is the answer?
41,000
How Difficult (1-3)?
1
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
2
Choose the question to remove?
0. What is the capital of Georgia?
1. What is the name of the mascot for KSU?
2. How many fingers does a typical human have?
3. How many students does KSU have?
3
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
4
What is the capital of Georgia?
Atlanta
Correct
What is the name of the mascot for KSU?
Scrappy
Correct
How many fingers does a typical human have?
6
Incorrect
You got 2 out of 3
What would you like to do?
1. Add a question to the quiz
2. Remove a question from the quiz
3. Modify a question in the quiz
4. Take the quiz
5. Quit
5

 */