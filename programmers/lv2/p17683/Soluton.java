package programmers.lv2.p17683;

import java.util.Map;

class Solution {
    public static String solution(String m, String[] musicinfos) {

        // 길이가 제일 긴 음악이 제일 재싱시간이 길다.
        m = Solution.replaceShop(m);

        String nameOfTheSong = "";
        int playtimeOfTheSong = 0;
        for (String musicInfo : musicinfos) {
            StringBuilder playedMusic = new StringBuilder();

            String[] arr = musicInfo.split(",");
            // 시간이 문제네, 23:55 ~ 00:05 인 케이스.
            int startTime = Solution.toMinutes(arr[0]);
            int endTime = Solution.toMinutes(arr[1]);
            if (endTime < startTime) {
                endTime += 24;
            }

            int playTime = endTime - startTime;

            String musicName = arr[2];
            String totalMelody = Solution.replaceShop(arr[3]);
            int melodyIndex = 0;
            for (int j = 0; j < playTime; j++) {
                playedMusic.append(totalMelody.charAt(melodyIndex));

                melodyIndex++;
                if (melodyIndex == totalMelody.length()) {
                    melodyIndex = 0;
                }
            }

            if (playedMusic.toString().contains(m)) {
                if (nameOfTheSong.isEmpty()) {
                    nameOfTheSong = musicName;
                    playtimeOfTheSong = playTime;
                } else {
                    if (playTime > playtimeOfTheSong) {
                        nameOfTheSong = musicName;
                        playtimeOfTheSong= playTime;
                    }
                }
            }
        }

        if (!nameOfTheSong.isEmpty()) {
            return nameOfTheSong;
        } else {
            return "(None)";
        }
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String replaceShop(String melody) {
        String result = melody;
        Map<String, String> shopMap = Map.of(
                "C#", "1",
                "D#", "2",
                "E#", "3",
                "F#", "4",
                "G#", "5",
                "A#", "6",
                "B#", "7"
        );

        for (Map.Entry<String, String> entry : shopMap.entrySet()) {
            if (melody.contains(entry.getKey())) {
                result = result.replace(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }
}

// 시작 시각, 끝난 시각, 음악 제목, 악보 정보

// 결국 기억한 멜로디가 전체 재생된 멜로디 안에 있냐 이거임.

// ---
// 1일차. 읽는데 10분 딴짓 10분
// 2일차. 읽는데 5분, 해결 방법 생각 10분, 푸는데 15분. 해결 방법 정리까지 왔음.구현이 오래걸림. 미구현.
// 3일차. 구현하는데 30분. 오류 고치는데 3분.
