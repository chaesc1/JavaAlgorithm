import java.util.*;
import java.io.*;

public class Main {

    static class Event {
        int time;
        int type;

        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            reverse(a);

            long[] mx = new long[n];
            mx[0] = a[0];
            for (int i = 1; i < n; i++) {
                mx[i] = mx[i - 1] + a[i];
            }

            List<Event> events = new ArrayList<>();
            Set<Integer> timesSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                timesSet.add(l);
                timesSet.add(r + 1);
                events.add(new Event(l, 1));
                events.add(new Event(r + 1, -1));
            }

            List<Integer> times = new ArrayList<>(timesSet);
            Collections.sort(times);
            Collections.sort(events, Comparator.comparingInt(e -> e.time));

            int p = 0;
            long ans = 0, ans2 = 0;

            times.add(times.get(times.size() - 1) + 1);

            for (int t = 0, j = 0; t < times.size() - 1; t++) {
                int added = 0, removed = 0;

                while (j < events.size() && events.get(j).time <= times.get(t)) {
                    if (events.get(j).type == 1) {
                        added++;
                    } else {
                        removed++;
                    }
                    j++;
                }

                p += added - removed;

                int dt = times.get(t + 1) - times.get(t);
                if (p > 0) {
                    ans += (long) dt * mx[p - 1];
                    if (n - 1 - p >= 0) {
                        ans2 += (long) dt * (mx[n - 1] - mx[n - 1 - p]);
                    } else {
                        ans2 += (long) dt * mx[n - 1];
                    }
                }
            }

            System.out.println(ans2 + " " + ans);
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void reverse(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
