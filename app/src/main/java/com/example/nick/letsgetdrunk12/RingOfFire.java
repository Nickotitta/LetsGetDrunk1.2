package com.example.nick.letsgetdrunk12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RingOfFire extends AppCompatActivity {

    ListView ringOfF;

    int[] images = {R.drawable.ahearts,
            R.drawable.twohearts,
            R.drawable.threehearts,
            R.drawable.fourhearts,
            R.drawable.fivehearts,
            R.drawable.sixhearts,
            R.drawable.sevenhearts,
            R.drawable.eighthearts,
            R.drawable.ninehearts,
            R.drawable.tenheart,
            R.drawable.jhearts,
            R.drawable.qhearts,
            R.drawable.khearts,
    };

    String[] Names = {"A",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "Knäckt",
            "Drottning",
            "Kung",
    };
    String[] Info = {
             "VATTTENFALL",

            "Two is you. Ta en klunk",

            "Three is me. Ta du själv en klunk",

            "Four is whore. Alla tjejer tar en klunk",

            "Thumbmaster. Du avgör när det är dags att köra",

            "Six is dicks. Alla killar tar en klunk",

            "Seven is heaven. Funkar precis som högerregeln fast med ett finger upp i luften",

            "Eight is mate. Välj en parnter och varje gång du dricker ska den partnern också dricka med dig",

            "Nine is rhyme. Välj ett ord och låt nästa person hitta ett rim till det. Den som inte kommer på ett ord som rimmar får ta en klunk.",

            "Väl ett kategori så som bilar eller sminkmärken till exempel och låt varje person säga något till det kategoriet. Den som inte kommer på mer tar en klunk. ",

            "Hitta på en regel som gruppen måste följa ananrs blir det en straffklunk. ",

            "Ställ en fråga till hela gruppen eller till en individ. Ifall gruppen eller individen svarar fel blir den en straffklunk. Annars får personen som ställde frågan ta en straffklunk",

            "Häll lite av din drink i glaset som står omringad av korten. Personen som får upp det sista kungen får dricka upp hela skiten.",

    };

    //Skapa en text här för varje lista här!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_of_fire);


        ringOfF = (ListView) findViewById(R.id.ListViewRoF);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        ringOfF.setAdapter(customAdaptor);



    }
    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView mImageView = (ImageView) view.findViewById(R.id.imageView);
            TextView mTextView = (TextView) view.findViewById(R.id.textView);
            TextView mTextView2 = (TextView) view.findViewById(R.id.textView2);

            mTextView2.setText(Info[position]);
            mImageView.setImageResource(images[position]);
            mTextView.setText(Names[position]);
            return view;
        }
    }
}
