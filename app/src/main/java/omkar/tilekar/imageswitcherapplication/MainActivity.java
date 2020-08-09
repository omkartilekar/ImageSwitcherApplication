package omkar.tilekar.imageswitcherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button button;
    TextView textView;
    int image_data[]={R.drawable.image1,R.drawable.images2,R.drawable.image3,R.drawable.images4,R.drawable.images5};
    String name_arr[]={"Tiger","Cat","Parrot","Bird","Dog"};
    int count=image_data.length;
    int img_index=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageSwitcher=findViewById(R.id.imageSwitcher);
        button=findViewById(R.id.button);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(R.drawable.images2);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        Animation animation_in= AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        Animation animation_out= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        imageSwitcher.setInAnimation(animation_in);
        imageSwitcher.setOutAnimation(animation_out);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_index++;
                if(img_index==count) {
                    img_index=0;
                }
                imageSwitcher.setImageResource(image_data[img_index]);
                if(img_index==0) {
                    textView.setText("TIGER");
                    imageSwitcher.setImageResource(image_data[img_index]);
                }else if(img_index==1)
                {
                    textView.setText("CAT");
                    imageSwitcher.setImageResource(image_data[img_index]);
                }else
                if(img_index==2)
                {
                    textView.setText("BIRD");
                    imageSwitcher.setImageResource(image_data[img_index]);
                }else if(img_index==3)
                {
                    textView.setText("PARROT");
                    imageSwitcher.setImageResource(image_data[img_index]);
                }else if(img_index==4)
                {
                    textView.setText("DOG");
                    imageSwitcher.setImageResource(image_data[img_index]);
                }
            }
        });

    }
}