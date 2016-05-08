package co.com.jonny.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mTabLayout = (TabLayout) findViewById(R.id.tabs_LAyout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager_Pager);
        setUpViewPager();


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasPrincipalesFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    public void setUpViewPager(){
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_action_house);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.favoritos_menu:
                Intent intent = new Intent(this, Favoritas.class);
                startActivity(intent);
                break;
            case R.id.contacto_menu:
                Intent intent2 = new Intent(this, ContactoActividad.class);
                startActivity(intent2);
                break;
            case R.id.acerca_menu:
                Intent intent3 = new Intent(this, AcercaActividad.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




}
