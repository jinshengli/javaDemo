package collection;

import generic.Song;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * create by ljs on 2020/6/26 8:32
 * <p>
 * description:
 */
public class HashSetDemo {


    public static void main(String[] args) {


        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song(1,"aaa", "chenj"));
        songs.add(new Song(1,"aaa", "chenj"));
        songs.add(new Song(32, "aaa", "woed"));
        songs.add(new Song(12, "aaaa", "aaadsadsadsfds"));

        HashSet<Song> songSet = new HashSet<>();

        songSet.addAll(songs);

        for (Song song : songSet) {

            System.out.println(song);

        }





    }


}
