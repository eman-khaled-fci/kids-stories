package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] animals={"The Lion And The Mouse","The Ugly Duckling"
            , "Who Will Bell The Cat?","The Clever Monkey"};
    private int[] animalSounds={R.raw.lion,R.raw.duck,R.raw.cat,R.raw.monkey};
    private int[] animalPictures={R.drawable.lion,R.drawable.duck,R.drawable.cat,R.drawable.monkey};
    private String[] animalStories={
          "One day, the king of the forest, the mighty lion was sleeping in his den, his head resting on his massive paws. A little mouse was playing nearby. The cave was huge and dark, and one could only hear the lion snore.\n" +
                  "\n" +
                  "Seeing the lion asleep, the mouse wondered how the king’s den looked like. So, he quietly crawled inside the cave while the lion was sleeping. But suddenly the mouse tripped into the lion’s nose, waking him up from his sleep. Seeing the mouse, the jungle king got very angry and pinned the mouse down with his paws."
            ,
            "A farmer had a duck, which laid ten eggs. Soon, they all hatched. Of the ten, nine ducklings looked like the mom. The tenth one was big, gray and ugly. All the other ducklings made fun of the ugly one. Unhappy in the farm, the poor duckling ran away to a river nearby. There he sees white, beautiful swans. Afraid and lost, he wanted to drown in the river. But when he looked at his reflection in the river, he realized that he was not an ugly duckling, but a beautiful swan!"
            ,
            "A horde of mice gathered one night to discuss the problems created by their common enemy, the cat. A lot of ideas were shared, but none seemed good enough to beat the cat. Then a young mouse suggested that they should tie a bell around the cat’s neck to know when it is approaching and escape the sly cat’s attacks. To this, an old, wise mouse asked, “That’s fine. But who will bell the cat?”"
            ,
            "Once upon a time, a clever monkey lived on an apple tree. It was friends with a foolish crocodile that lived in the river. The mokey shared the fruits of the tree with the crocodile everyday. The crocodile’s wife learns about this friendship and asks the crocodile to bring the monkey’s heart, which could be sweeter than the fruits of the tree. The couple invite the monkey for dinner and plan to eat his heart. The crocodile offers to take the monkey on its back, so that it can cross the river to reach home.\n" +
                    "\n" +
                    "On their way, the foolish crocodile mentions his wife’s desire to taste the monkey’s heart. The monkey is quick to understand its friend’s intentions and tricks it by saying: “Oh, but I forgot my heart at home. Take me back so we can get it.” As soon as they reach the river bank, the monkey jumps off the crocodile’s back, and vows never to trust it again."











    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, animals);


        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,animalSounds[position]);
                mediaPlayer.start();
                Intent i=new Intent(MainActivity.this,StoryActivity.class);
                i.putExtra("picture",animalPictures[position]);
                i.putExtra("story",animalStories[position]);
                i.putExtra("actionBar",animals[position]);
                startActivity(i);
            }
        });
    }
    public void goToSettings(View v){
        Intent i=new Intent(MainActivity.this,Settings.class);
        startActivity(i);
    }
}
