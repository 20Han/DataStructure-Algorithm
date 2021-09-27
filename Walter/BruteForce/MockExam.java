import java.util.*;

class Solution {
    
    public static class Person implements Comparable<Person> {
        private final List<Integer> answerList;
        private int number;
        private int score = 0;

        public Person(List<Integer> answerList) {
            this.answerList = answerList;
        }

        public Person setNumber(int number) {
            this.number = number;
            return this;
        }

        public void incrementScore() {
            this.score++;
        }

        public int getNumber() {
            return number;
        }

        public int getScore() {
            return score;
        }

        public int getAnswer(int index) {
            return answerList.get(index);
        }

        public int size() {
            return answerList.size();
        }

        @Override
        public int compareTo(Person that) {
            return this.score - that.score;
        }
    }
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        Person firstPerson = new Person(List.of(1,2,3,4,5)).setNumber(1);
        Person secondPerson = new Person(List.of(2,1,2,3,2,4,2,5)).setNumber(2);
        Person thirdPerson = new Person(List.of(3,3,1,1,2,2,4,4,5,5)).setNumber(3);

        int firstPersonIndex = 0;
        int secondPersonIndex = 0;
        int thirdPersonIndex = 0;

        for (int index = 0; index < answers.length; index++) {
            int currentAnswer = answers[index];

            firstPersonIndex = (index % firstPerson.size());

            if (firstPerson.getAnswer(firstPersonIndex) == currentAnswer)
                firstPerson.incrementScore();

            secondPersonIndex = (index % secondPerson.size());

            if (secondPerson.getAnswer(secondPersonIndex) == currentAnswer)
                secondPerson.incrementScore();

            thirdPersonIndex = (index % thirdPerson.size());

            if (thirdPerson.getAnswer(thirdPersonIndex) == currentAnswer)
                thirdPerson.incrementScore();
        }

        List<Person> scores = List.of(firstPerson, secondPerson, thirdPerson);

        int max = Collections.max(scores).getScore();

        answer = scores.stream()
                .filter(person -> person.getScore() == max)
                .mapToInt(Person::getNumber)
                .toArray();
        
        return answer;
    }
}
