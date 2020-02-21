package com.leetcode.chen.optimize.GuessTheWord;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/guess-the-word/
 * <p>
 * User: Chen Liu
 * Date: 2020/2/3
 * Time: 10:07 pm
 */
@Slf4j
public class Solution {
    public void findSecretWord(String[] wordList, Master master) {
        List<Word> words = this.preProcessing(wordList);
        int highestScore = 0;
        String highestWord = words.get(0).value;
        for (int i = 0; i < 10; i++) {
            String guessWord = words.get(0).value;
            words.remove(0);
            while (matchScore(guessWord, highestWord) < highestScore) {
                guessWord = words.get(0).value;
                words.remove(0);
            }
            // Get score
            int score = master.guess(guessWord);
            log.info("No {}. Guess {}, score: {}", i + 1, guessWord, score);
            if (score == 6) {
                log.info("Bingo! {}", guessWord);
                break;
            }
            if (score > highestScore) {
                highestScore = score;
                highestWord = guessWord;
            }
            final String gw = guessWord;
            if (score == highestScore) {
                // Remove all matchScore != score
                words.removeIf(w -> matchScore(gw, w.value) != score);
            } else {
                // Remove if matchScore > score
                words.removeIf(w -> matchScore(gw, w.value) > score);
            }
            log.info("List length: {}", words.size());
            if (words.size() < 15) {
                log.info("{}", words);
            }
        }
    }

    public List<Word> preProcessing(String[] wordList) {
        List<Word> list = this.buildWordList(wordList);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Word first = list.get(i);
            for (int j = i + 1; j < size; j++) {
                Word second = list.get(j);
                int score = matchScore(first.value, second.value);
                first.count += score == 0 ? 0 : 1;
                second.count += score == 0 ? 0 : 1;
            }
        }
        list.sort(((o1, o2) -> o1.count > o2.count ? -1 : 1));
        return list;
    }

    public List<Word> buildWordList(String[] wordList) {
        List<Word> list = new ArrayList<>();
        for (String s : wordList) {
            list.add(new Word(s));
        }
        return list;
    }

    /**
     * Cal the match score
     *
     * @param guess  guess
     * @param target target
     * @return int
     */
    public static int matchScore(String guess, String target) {
        int score = 0;
        String[] g = guess.split("");
        String[] t = target.split("");
        for (int i = 0; i < 6; i++) {
            score += g[i].equals(t[i]) ? 1 : 0;
        }
        return score;
    }

    private class Word {
        private String value;
        private int count;

        public Word(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + value + ", " + count + ")";
        }
    }

    public static void main(String[] args) {
        String secret = "ccoyyo";
        String[] wordList = new String[]{"wichbx",
                "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"};
        Solution solution = new Solution();
//        log.info("{}", solution.preProcessing(wordList));
        solution.findSecretWord(wordList, (word) -> matchScore(word, secret));
    }
}
