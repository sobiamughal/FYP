package com.example.roubaisha.counter.Names;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.roubaisha.counter.R;

import java.util.ArrayList;

public class AllahNamesActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager mLayoutManager;
    Toolbar toolbar;
    ImageButton name_playbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allah_names);

        getSupportActionBar().setTitle("Allah Names");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.name_actionbar);
        //setSupportActionBar(toolbar);
        name_playbtn = (ImageButton) findViewById(R.id.name_playbtn);
        name_playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AllahNamesActivity.this, "play karao apni marzi sy audio", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.re);
        mLayoutManager = new LinearLayoutManager(AllahNamesActivity.this);
        /* RecyclerView.LayoutManager la = new StaggeredGridLayoutManager(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS, StaggeredGridLayoutManager.VERTICAL);*/
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<NameModel> arrayList=new ArrayList<NameModel>();
        
        arrayList.add(new NameModel("الله","Allah","Allah","الله", R.raw.allah));
        arrayList.add(new NameModel("الرَّحْمَنُ","Ar-Rahman","The Most or Entirely Merciful","الرحمن", R.raw.rahman));
        arrayList.add(new NameModel("الرَّحِيمُ","Ar-Raheem","The Bestower of Mercy","الرحيم", R.raw.rahim));
        arrayList.add(new NameModel("الْمَلِك","Al-Malik","The King and Owner of Dominion","الملك", R.raw.malik));
        arrayList.add(new NameModel("ُ الْقُدُّوسُُ","Al-Quddus","The Absolutely Pure","القدوس", R.raw.quddus));
        arrayList.add(new NameModel(" السَّلاَمُ","As-Salam","The Perfection and Giver of Peace","السلام", R.raw.salam));
        arrayList.add(new NameModel(" الْمُؤْمِنُ","Al-Mu'min","The One Who gives Emaan and Security","المؤمن", R.raw.mumin));
        arrayList.add(new NameModel(" الْمُهَيْمِنُ","Al-Muhaymin","The Guardian, The Witness, The Overseer","المهيمن", R.raw.muhaimin));
        arrayList.add(new NameModel(" الْعَزِيز","Al-Aziz","The All Mighty","العزيز", R.raw.aziz));
        arrayList.add(new NameModel("ُ الْجَبَّار","AL-Jabbar","The Compeller, The Restorer","الجبار", R.raw.jabbar));

        arrayList.add(new NameModel("الْمُتَكَبِّر","Al-Mutakabbir","The Supreme, The Majestic","المتكبر", R.raw.mutakabbir));
        arrayList.add(new NameModel("ُ الْخَالِقُ","Al-Khaliq","The Creator, The Maker","الخالق", R.raw.khaliq));
        arrayList.add(new NameModel("ُ الْبَارِئُ","Al-Bari","The Originator","البارئ", R.raw.bari));
        arrayList.add(new NameModel(" الْمُصَوِّر","Al-Musawwir","The Fashioner","المصور", R.raw.musawwir));
        arrayList.add(new NameModel("ُ الْغَفَّارُ","Al-Ghaffar","The Ever-Dominating","الغفار", R.raw.ghaffar));
        arrayList.add(new NameModel("الْقَهَّار","Al-Qahhar","The Subduer","القهار", R.raw.qahhar));
        arrayList.add(new NameModel("ُ الْوَهَّابُ","Al-Wahhab","The Giver of Gifts ","الوهاب", R.raw.wahhab));
        arrayList.add(new NameModel("الرَّزَّاقُ","Ar-Razzaq","The Provider","الرزاق", R.raw.razzaq));
        arrayList.add(new NameModel(" الْفَتَّاح","Al-Fattah","The Opener, The Judge","الفتاح", R.raw.fattah));
        arrayList.add(new NameModel("ُ اَلْعَلِيْم","Al-`Alim","The All-Knowing, The Omniscient","العليم", R.raw.alim));

        arrayList.add(new NameModel("الْقَابِضُ","Al-Qabid","The Withholder","القابض", R.raw.qabid));
        arrayList.add(new NameModel("الْبَاسِطُُ","Al-Basit","The Extender","الباسط", R.raw.basit));
        arrayList.add(new NameModel(" الْخَافِضُ","Al-Khafid","The Reducer","الخافض", R.raw.khafid));
        arrayList.add(new NameModel(" الرَّافِعُ ","Ar-Rafi","The Exalter","الرافع", R.raw.rafi));
        arrayList.add(new NameModel("الْمُعِزُّ"," Al-Mu'id","The Honourer","المعز", R.raw.muid));
        arrayList.add(new NameModel("المُذِلُّ ","Al-Mudhill ","The Dishonourer","المذل", R.raw.mudhill));
        arrayList.add(new NameModel("السَّمِيعُ ","As-Sami","The All-Hearing","السميع", R.raw.sami));
        arrayList.add(new NameModel("الْبَصِيرُ ","Al-Basir","The All-Seeing","البصير", R.raw.basir));
        arrayList.add(new NameModel("الْحَكَمُ ","Al-Hakam","The Giver of Justice","الحكم", R.raw.hakam));
        arrayList.add(new NameModel("الْعَدْلُ ","Al-`Adl","The Utterly Just","العدل", R.raw.adl));
        arrayList.add(new NameModel("اللَّطِيف","Al-Latif","The Most Gentle","اللطيف", R.raw.latif));

        arrayList.add(new NameModel("الْخَبِيرُ","Al-Khabir","The Acquainted","الخبير", R.raw.khabir));
        arrayList.add(new NameModel("ُ الْحَلِيمُ","Al-Halim","The Most Forbearing","الحليم", R.raw.halim));
        arrayList.add(new NameModel(" الْعَظِيم","Al-Azim","The Supreme","العظيم", R.raw.azim));
        arrayList.add(new NameModel("ُ الْغَفُورُ","Al-Ghafur","The Forgiving","الغفور", R.raw.ghafur));
        arrayList.add(new NameModel(" الشَّكُورُ","Ash-Shakur","The Most Appreciative","الشكور", R.raw.shakur));
        arrayList.add(new NameModel(" الْعَلِيُّ","Al-Ali","The Most High","العلي", R.raw.ali));
        arrayList.add(new NameModel(" الْكَبِير","Al-Kabir","The Greatest","الكبير", R.raw.kabir));
        arrayList.add(new NameModel("ُ الْحَفِيظُ","Al-Hafiz","The Preserver","الحفيظ", R.raw.hafiz));
        arrayList.add(new NameModel(" المُقيِت","Al-Muqit","The Sustainer","المقيت", R.raw.muqit));
        arrayList.add(new NameModel("الْحسِيب","Al-Hasib","The Sufficient","الحسيب", R.raw.hasib));

        arrayList.add(new NameModel("الْجَلِيلُُ","Al-Jalil","The Majestic","الجليل", R.raw.jalil));
        arrayList.add(new NameModel("الْكَرِيمُ","Al-Karim","The Most Generous","الكريم", R.raw.karim));
        arrayList.add(new NameModel(" الرَّقِيبُ ","Ar-Raqib","The Watchful","الرقيب", R.raw.raqib));
        arrayList.add(new NameModel("الْمُجِيبُ","Al-Mujib","The Responsive One","المجيب", R.raw.mujib));
        arrayList.add(new NameModel(" الْوَاسِعُ","Al-Wasi","The All-Encompassing","الواسع", R.raw.wasi));
        arrayList.add(new NameModel("الْحَكِيمُ","Al-Hakim","The All-Wise","الحكيم", R.raw.hakim));
        arrayList.add(new NameModel("الْوَدُودُ","Al-Wadud","The Most Loving","الودود", R.raw.wadud));
        arrayList.add(new NameModel("الْمَجِيدُ","Al-Majid","The Glorious","المجيد", R.raw.majeed));
        arrayList.add(new NameModel("الْبَاعِثُ","Al-Ba'ith","The Resurrector","الباعث", R.raw.baith));
        arrayList.add(new NameModel(" الشَّهِيد","Ash-Shahid","The All- and Ever Witnessing","الشهيد", R.raw.shahid));

        arrayList.add(new NameModel("الْحَقُّ","Al-Haqq","The Absolute Truth","الحق", R.raw.haqq));
        arrayList.add(new NameModel(" الْوَكِيلُ","Al-Wakil","The Trustee","الوكيل", R.raw.wakil));
        arrayList.add(new NameModel(" الْقَوِيُّ","Al-Qawiyy","The All-Strong","القوى", R.raw.qawi));
        arrayList.add(new NameModel(" الْمَتِينُ","Al-Matin","The Firm","المتين", R.raw.matin));
        arrayList.add(new NameModel("الْوَلِيُ","Al-Waliyy","The Protecting Associate","الولى", R.raw.wali));
        arrayList.add(new NameModel("الْحَمِيدُ","Al-Hamid","The Praiseworthy","الحميد", R.raw.hamid));
        arrayList.add(new NameModel("الْمُحْصِي","Al-Muhsi","The Counter","المحصى", R.raw.muhsi));
        arrayList.add(new NameModel("الْمُبْدِئُ","Al-Mubdi'","The Originator","المبدئ", R.raw.mubdi));
        arrayList.add(new NameModel("الْمُعِيدُ","Al-Mu'id","The Restorer","المعيد", R.raw.muid));
        arrayList.add(new NameModel("الْمُحْيِي","Al-Muhyi","The Giver of Life","المحيى", R.raw.muhyi));

        arrayList.add(new NameModel("اَلْمُمِيتُُ","Al-Mumit","The Bringer of Death","المميت", R.raw.mumit));
        arrayList.add(new NameModel(" الْحَيُّ","Al-Hayy","The Ever-Living","الحي", R.raw.hayy));
        arrayList.add(new NameModel(" الْقَيُّومُ","Al-Qayyum","The Sustainer","القيوم", R.raw.qayyum));
        arrayList.add(new NameModel("الْوَاجِدُ","Al-Wajid","The Perceiver","الواجد", R.raw.wajid));
        arrayList.add(new NameModel(" الْمَاجِدُ","Al-Majid","The Illustrious","المجيد", R.raw.majid));
        arrayList.add(new NameModel("الْواحِدُ","Al-Wahid","The One","الواحد", R.raw.wahid));
        arrayList.add(new NameModel("الصَّمَدُ","As-Samad","The Eternal","الصمد", R.raw.samad));
        arrayList.add(new NameModel(" الْقَادِر","Al-Qadir","The Capable","القادر", R.raw.qadir));
        arrayList.add(new NameModel("ُ الْمُقْتَدِرُ","Al-Muqtadir","The Omnipotent","المقتدر", R.raw.muqtadir));
        arrayList.add(new NameModel("الْمُقَدِّم","Al-Muqaddim","The Promoter","المقدم", R.raw.muqaddim));

        arrayList.add(new NameModel("الْمُؤَخِّرُ","Al-Mu'akhkhir","The Delayer","المؤخر", R.raw.muakhkhir));
        arrayList.add(new NameModel("ُ الأوَّلُ","Al-Awwal","The First","الأول", R.raw.awwal));
        arrayList.add(new NameModel(" الآخِرُ","Al-Akhir","The Last","الأخر", R.raw.akhir));
        arrayList.add(new NameModel("الظَّاهِرُ","Az-Zahir","The Manifest","الظاهر", R.raw.zahir));
        arrayList.add(new NameModel("الْبَاطِنُ","Al-Batin","The Hidden One","الباطن", R.raw.batin));
        arrayList.add(new NameModel("الْوَالِي","Al-Wali","The Governor","الوالي", R.raw.waliy));
        arrayList.add(new NameModel("الْمُتَعَالِي","Al-Muta'ali","The Self Exalted","المتعالي", R.raw.muta_ali));
        arrayList.add(new NameModel("الْبَرُّ","Al-Barr","The Source of Goodness","البر", R.raw.barr));
        arrayList.add(new NameModel("التَّوَابُ","At-Tawwab","The Ever-Pardoning","التواب", R.raw.tawwab));
        arrayList.add(new NameModel("الْمُنْتَقِم","Al-Muntaqim","The Avenger","المنتقم", R.raw.muntaqim));

        arrayList.add(new NameModel("العَفُوَُّّ","Al-'Afuww","The Pardoner","العفو", R.raw.afuw));
        arrayList.add(new NameModel(" الرَّؤُوفُ","Ar-Ra'uf","The Most Kind","الرؤوف", R.raw.rauf));
        arrayList.add(new NameModel("مَالِكُ الْمُلْكِ","Malik-al-Mulk","Master of the Kingdom","مالك الملك", R.raw.malik_ul_mulk));
        arrayList.add(new NameModel(" ذُوالْجَلاَلِ وَالإكْرَامِ","Dhu-al-Jalal wa-al-Ikram","Possessor of Glory and Honour"," ذوالجلال والإكرام", R.raw.dhu_l_jalali_wal_ikram));
        arrayList.add(new NameModel(" الْمُقْسِطُ","Al-Muqsit","The Equitable","المقسط", R.raw.muqsit));
        arrayList.add(new NameModel(" الْجَامِعُ","Al-Jami'","The Gatherer","الجامع", R.raw.jami));
        arrayList.add(new NameModel("الْغَنِيُّ","Al-Ghani","The Self-Sufficient","الغني", R.raw.ghaniy));
        arrayList.add(new NameModel(" الْمُغْنِي","Al-Mughni","The Enricher","المغني", R.raw.mughni));
        arrayList.add(new NameModel("اَلْمَانِعُ","Al-Mani'","The Withholder","المانع", R.raw.mani));
        arrayList.add(new NameModel("الضَّار","Ad-Darr","The Distresser","الضار", R.raw.darr));

        arrayList.add(new NameModel("النَّافِعُُ","An-Nafi'","The Propitious","النافع", R.raw.nafi));
        arrayList.add(new NameModel("النُّورُ","An-Nur","The Light","النور", R.raw.nur));
        arrayList.add(new NameModel("الْهَادِي","Al-Hadi","The Guide","الهادي", R.raw.hadi));
        arrayList.add(new NameModel("الْبَدِيعُ","Al-Badi","The Incomparable Originator","البديع", R.raw.badi));
        arrayList.add(new NameModel("اَلْبَاقِي","Al-Baqi","The Ever-Surviving","الباقي", R.raw.baqi));
        arrayList.add(new NameModel("الْوَارِثُ","Al-Warith","The Inheritor","الوارث", R.raw.warith));
        arrayList.add(new NameModel("الرَّشِيدُ"," Ar-Rashid","The Guide","الرشيد", R.raw.rashid));
        arrayList.add(new NameModel("الصَّبُور","As-Sabur","The Forbearing","الصبور", R.raw.sabur));



        RecyclerAdapter adapter=new RecyclerAdapter(AllahNamesActivity.this,arrayList);
        recyclerView.setAdapter(adapter);
    }

   // @Override
    //public void onBackPressed() {
      //  AlertDialog.Builder builder =
        //        new AlertDialog.Builder(AllahNamesActivity.this);
    //    builder.setTitle(" Names Of Allah ");
    //    builder.setMessage(" আপনি কি অ্যাপ হতে বের হতে চান ? ");


    //    builder.setPositiveButton(" হ্যা ",new DialogInterface.OnClickListener() {
    //        public void onClick(DialogInterface dialog,int id)
    //        {
    //            AllahNamesActivity.this.finish();
    //        }

    //    });
    //    builder.setNegativeButton(" না ",null);

    //    builder.show();
   // }
}
