package com.leetcode.chen.processing.ExamRoom;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/exam-room/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/4
 * Time: 8:11 pm
 */
@Slf4j
public class ExamRoom {
    private int total;
    private int[] seats;
    private int start;
    private int longest;

    public ExamRoom(int N) {
        this.seats = new int[N];
        this.total = N;
        this.start = 0;
        this.longest = N;
    }

    public int seat() {
        int seatNo;
        if (this.longest == this.total) {
            seatNo = 0;
        } else if (this.longest == this.total - 1) {
            seatNo = this.seats[0] == 1 ? this.total - 1 : 0;
        } else {
            seatNo = this.start + (int) Math.ceil(this.longest / 2.0);
        }
        this.seats[seatNo] = 1;
        this.calStartAndEnd();
        return seatNo;
    }

    public void leave(int p) {
        this.seats[p] = 0;
        this.calStartAndEnd();
    }

    /**
     * Cal start and end after seat() and leave()
     */
    public void calStartAndEnd() {
        int current = 0;
        this.start = 0;
        this.longest = 0;
        for (int i = 0; i < this.total; i++) {
            if (this.seats[i] == 1) {
                if ((this.longest == 0 && current > this.longest) || current > this.longest + 1) {
                    this.longest = current;
                    this.start = i - this.longest - 1;
                }
                // Restart count length
                current = 0;
            }
            if (this.seats[i] == 0) {
                current++;
            }
        }
        if (current > this.longest) {
            this.longest = current;
            this.start = this.total - 1 - this.longest;
        }
//        log.info("Start: {}, Longest: {}", this.start, this.longest);
    }

    public static void main(String[] args) {
        ExamRoom obj = new ExamRoom(0);
//        String[] ops = new String[]{"ExamRoom", "seat", "seat", "seat", "leave", "leave", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "seat", "leave"};
//        int[] params = new int[]{10, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        String[] ops = new String[]{"ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"};
//        int[] params = parseString("[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]");
        String[] ops = new String[]{"ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat"};
        int[] params = parseString("[[8],[],[],[],[0],[7],[],[],[],[],[],[],[]]");
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            int param = params[i];
            switch (op) {
                case "ExamRoom":
                    obj = new ExamRoom(param);
                    break;
                case "seat":
                    log.info("Sit at number {}", obj.seat());
                    break;
                case "leave":
                    obj.leave(param);
                    log.info("Leave number {}", param);
                    break;
            }
        }
    }

    public static int[] parseString(String str) {
        str = str.replace("[", "").replace("]", "");
        String[] strs = str.split(",", -1);
        int length = strs.length;
        int[] params = new int[length];
        for (int i = 0; i < length; i++) {
            String s = strs[i];
            params[i] = "".equals(s) ? 0 : Integer.parseInt(s);
        }
        return params;
    }
}
