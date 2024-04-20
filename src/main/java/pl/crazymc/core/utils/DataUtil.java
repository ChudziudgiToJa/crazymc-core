package pl.crazymc.core.utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DataUtil {
    private static final LinkedHashMap<Integer, String> values = new LinkedHashMap<>();

    static {
        values.put(31104000, "r ");
        values.put(2592000, "m ");
        values.put(86400, "d ");
        values.put(3600, "h ");
        values.put(60, "m ");
        values.put(1, "s");
    }

    public static String secondsToString(final long l) {
        int seconds = (int) (l / 1000L);
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<Integer, String> e : values.entrySet()) {
            final int iDiv = seconds / e.getKey();
            if (iDiv >= 1) {
                final int x = (int) Math.floor(iDiv);
                sb.append(x).append(e.getValue());
                seconds -= x * e.getKey();
            }
        }
        return sb.toString();
    }

    public static String getDate(final long time) {
        return new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss").format(new Date(time));
    }

    public static long parseString(final String string) {
        final List<String> list = new ArrayList<>();
        int goBack = 0;
        for (int i = 0; i < string.length(); ++i) {
            final String c = String.valueOf(string.charAt(i));
            if (c.matches("[a-zA-Z]")) {
                list.add(string.substring(goBack, i + 1));
                goBack = i + 1;
            }
        }
        long total = 0L;
        for (final String st : list) {
            final char ch = st.charAt(st.length() - 1);
            if (st.length() != 1 && String.valueOf(ch).matches("[smhd]")) {
                final long amount = Math.abs(Integer.parseInt(st.substring(0, st.length() - 1)));
                switch (ch) {
                    default: {
                        continue;
                    }
                    case 's': {
                        total += amount * 1000L;
                        continue;
                    }
                    case 'm': {
                        total += amount * 1000L * 60L;
                        continue;
                    }
                    case 'h': {
                        total += amount * 1000L * 3600L;
                        continue;
                    }
                    case 'd': {
                        total += amount * 1000L * 3600L * 24L;
                    }
                }
            }
        }
        if (total == 0L) {
            return -1L;
        }
        return total;
    }

    public static String milisToString(long time) {
        final String string = secondsToString((int) (time / (long) 1000));
        return string.length() == 0 ? time + "ms" : string;
    }

    public enum Time {
        SECOND(1000), MINUTE(60000), HOUR(3600000), DAY(86400000);

        private final int time;

        Time(final int time) {
            this.time = time;
        }

        public final int getTime(final int multi) {
            return time * multi;
        }
    }
}
