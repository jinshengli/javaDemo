package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * create by ljs on 2020/6/25 19:11
 * <p>
 * description:  排序ArrayList。
 *
 *
 *
 */
public class SortSongList {


    public static void main(String[] args) {

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song(1,"zbeot", "chenj"));
        songs.add(new Song(32, "love", "woed"));
        songs.add(new Song(12, "ad", "aaadsadsadsfds"));

//        Collections.sort(songs);
//
//        for (Song song : songs) {
//            System.out.println(song);
//        }

        Collections.sort(songs, new IdCompare());

        for (Song song : songs) {
            System.out.println(song);
        }




    }

    static class ArtistCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

    static class IdCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o2.getId().compareTo(o1.getId());
        }
    }



}
