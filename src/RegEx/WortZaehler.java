//package RegEx;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.StreamTokenizer;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.TreeMap;
//
///**
// * Created by dfleuren on 02.10.2015.
// */
//public class WortZaehler {
//
//    public void count(String data) {
//        try (BufferedReader br = new BufferedReader(
//                new FileReader(data))) {
//
//
//            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
//
//            String token = null;
//
//            while (st.nextToken() != StreamTokenizer.TT_EOF) {
//
//                token = st.sval;
//
//                Integer get = map.get(token);
//
//                if (get == null) {
//                    map.put(token, 1);
//                } else {
//                    map.put(token, get + 1);
//                }
//            }
//
//            List<String> list = new LinkedList<String>();
//            for (String key : map.keySet()) {
//                list.add(key);
//            }
//
//            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
//
//            for (String s : list) {
//                System.out.println(s + ": " + map.get(s));
//            }
//        }
//    }
//}

