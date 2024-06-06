package freePractise.sorting;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static class Participant implements Comparable<Participant> {
        public String getLogin() {
            return login;
        }

        public int getPoints() {
            return points;
        }

        public int getFines() {
            return fines;
        }

        private String login;
        private int points;
        private int fines;

        public Participant(String login, int points, int fines) {
            this.login = login;
            this.points = points;
            this.fines = fines;
        }

        @Override
        public int compareTo(Participant otherParticipant) {
            int otherPoints = otherParticipant.getPoints();
            int otherFines = otherParticipant.getFines();
            String otherLogin = otherParticipant.getLogin();

            if (this.points == otherPoints) {
                if (this.fines == otherFines)
                    return -(this.login.compareTo(otherLogin));
                else
                    return -(this.fines - otherFines);
            }

            return this.points - otherPoints;
        }
    }

    private static void quickSortInPlace(Participant[] arr, int low, int high) {
        if (low >= high)
            return;

        Participant pivot = arr[high];
        int left = low;
        int right = high - 1;

        while (left <= right) {
            while (left <= right && (arr[left].compareTo(pivot) >= 0))
                left++;
            while (left <= right && (arr[right].compareTo(pivot) <= 0))
                right--;
            if (left < right) swap(arr, left, right);
        }

        swap(arr, left, high);
        quickSortInPlace(arr, low, left - 1);
        quickSortInPlace(arr, left + 1, high);
    }

    private static void swap(Participant[] arr, int a, int b) {
        Participant temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        Participant[] participants = new Participant[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String login = tokenizer.nextToken();
            int points = Integer.parseInt(tokenizer.nextToken());
            int fines = Integer.parseInt(tokenizer.nextToken());
            Participant participant = new Participant(login, points, fines);
            participants[i] = participant;
        }

        quickSortInPlace(participants, 0, participants.length - 1);
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].getLogin());
        }

    }
}


