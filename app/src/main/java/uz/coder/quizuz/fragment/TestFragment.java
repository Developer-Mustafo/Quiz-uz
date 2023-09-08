package uz.coder.quizuz.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import uz.coder.quizuz.model.QuessionModel;
import uz.coder.quizuz.R;
import uz.coder.quizuz.databinding.FragmentTestBinding;
import uz.coder.quizuz.databinding.ItemDialogBinding;

public class TestFragment extends Fragment  {

    // TODO: Rename and change types of parameters
    private String laulage,a;
    private String myAnswer=null;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private int hisob;
    private int index = 0;
    private boolean javob = false;
    private List<QuessionModel> quessionModelList;

    public TestFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            a = getArguments().getString("laulage");
        }
    }
    FragmentTestBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTestBinding.inflate(inflater,container,false);
        sharedPreferences = requireContext().getSharedPreferences("S", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        laulage = sharedPreferences.getString("a",a);
        loadData();
        loadUi();
        binding.back.setOnClickListener(view -> {
            if (index != 0){
                index--;
                loadUi();
                hisob--;
                myAnswer = null;
                binding.forward.setVisibility(View.VISIBLE);
            }else {
                Toast.makeText(requireContext(), "Xozir siz 1 -inchi savoldasiz", Toast.LENGTH_SHORT).show();
                binding.back.setVisibility(View.INVISIBLE);
            }
            binding.round.setText(index + "/" + quessionModelList.size());
        });
        binding.forward.setOnClickListener(view -> {
            if (index != quessionModelList.size()-1){
                index++;
                loadUi();
                    binding.back.setVisibility(View.VISIBLE);
                myAnswer = null;
            }else {
                Toast.makeText(requireContext(), "Xozir siz oxirgi savoldasiz", Toast.LENGTH_SHORT).show();
                binding.forward.setVisibility(View.INVISIBLE);
            }
            binding.round.setText(index + "/" + quessionModelList.size());
        });
        binding.exit.setOnClickListener(view -> Navigation.findNavController(binding.getRoot()).navigate(R.id.startFragment));
        if (laulage != null){
            binding.laulage.setText(laulage);
        }
        binding.var1.setOnClickListener(view -> {
            myAnswer = binding.var1.getText().toString();
        });
        binding.var2.setOnClickListener(view -> {
            myAnswer = binding.var2.getText().toString();
        });
        binding.var3.setOnClickListener(view ->{
            myAnswer = binding.var3.getText().toString();
        });
        binding.var4.setOnClickListener(view -> {
            myAnswer = binding.var4.getText().toString();
        });
        binding.tekshir.setOnClickListener(view -> {
            if (myAnswer != null) {
                if (Objects.equals(myAnswer, quessionModelList.get(index).getTrueAnswer())) {
                    Toast.makeText(requireContext(), "Barakalla", Toast.LENGTH_SHORT).show();
                    javob = true;
                    hisob++;
                } else {
                    Toast.makeText(requireContext(), "Xato", Toast.LENGTH_SHORT).show();
                    javob = false;
                }
                index++;
            } else {
                Toast.makeText(requireContext(), "Javobni tanlang", Toast.LENGTH_SHORT).show();
                binding.var1.setBackgroundResource(R.drawable.item_button);
                binding.var2.setBackgroundResource(R.drawable.item_button);
                binding.var3.setBackgroundResource(R.drawable.item_button);
                binding.var4.setBackgroundResource(R.drawable.item_button);
            }
            if (index !=-1){
                binding.back.setVisibility(View.VISIBLE);
            }else {
                binding.back.setVisibility(View.INVISIBLE);
            }
            new CountDownTimer(2000,1000){
                @Override
                public void onTick(long l) {
                    if (javob){
                        for (int i = 0; i < quessionModelList.size(); i++) {
                            if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var1.getText().toString())) {
                                binding.var1.setBackgroundResource(R.drawable.item_true_answer);
                            }else if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var2.getText().toString())) {
                                binding.var2.setBackgroundResource(R.drawable.item_true_answer);
                            }else if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var3.getText().toString())) {
                                binding.var3.setBackgroundResource(R.drawable.item_true_answer);
                            }else if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var4.getText().toString())) {
                                binding.var4.setBackgroundResource(R.drawable.item_true_answer);
                            }
                        }
                    }else{
                        for (int i = 0; i < quessionModelList.size(); i++) {
                            if (Objects.equals(myAnswer, binding.var1.getText().toString())){
                                binding.var1.setBackgroundResource(R.drawable.item_false_answer);
                            } if (Objects.equals(myAnswer, binding.var2.getText().toString())){
                                binding.var2.setBackgroundResource(R.drawable.item_false_answer);
                            } if (Objects.equals(myAnswer, binding.var3.getText().toString())){
                                binding.var3.setBackgroundResource(R.drawable.item_false_answer);
                            } if (Objects.equals(myAnswer, binding.var4.getText().toString())){
                                binding.var4.setBackgroundResource(R.drawable.item_false_answer);
                            }

                            if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var1.getText().toString())) {
                                binding.var1.setBackgroundResource(R.drawable.item_true_answer);
                            } if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var2.getText().toString())) {
                                binding.var2.setBackgroundResource(R.drawable.item_true_answer);
                            } if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var3.getText().toString())) {
                                binding.var3.setBackgroundResource(R.drawable.item_true_answer);
                            } if (Objects.equals(quessionModelList.get(i).getTrueAnswer(), binding.var4.getText().toString())) {
                                binding.var4.setBackgroundResource(R.drawable.item_true_answer);
                            }
                        }
                    }

                    binding.round.setText(index + "/" + quessionModelList.size());
                }

                @Override
                public void onFinish() {
                    binding.var1.setBackgroundResource(R.drawable.item_button);
                    binding.var2.setBackgroundResource(R.drawable.item_button);
                    binding.var3.setBackgroundResource(R.drawable.item_button);
                    binding.var4.setBackgroundResource(R.drawable.item_button);
                    if (index <= quessionModelList.size()-1){
                        loadUi();
                    }
                    else {
                        Toast.makeText(requireContext(), "Savollar Tugadi", Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("l",laulage);
                        bundle.putInt("h",hisob);
                        bundle.putInt("hamma", quessionModelList.size());
                        ItemDialogBinding dialogBinding = ItemDialogBinding.inflate(inflater,container,false);
                        AlertDialog dialog = new AlertDialog.Builder(requireContext()).create();
                        dialog.setView(dialogBinding.getRoot());
                        dialog.setCancelable(false);
                        new CountDownTimer(3000, 1000) {
                            @Override public void onTick(long l) { dialog.show();}
                            @Override public void onFinish() {
                                index = 0;
                                dialog.dismiss();
                                Navigation.findNavController(binding.getRoot()).navigate(R.id.natijaFragment,bundle);
                            }

                        }.start();
                    }
                    binding.round.setText(index + "/" + quessionModelList.size());
                }
            }.start();
        });
        binding.round.setText(index + "/" + quessionModelList.size());
        return binding.getRoot();
    }

    private void loadUi() {
            binding.savol.setText(quessionModelList.get(index).getQuession());
            binding.var1.setText(quessionModelList.get(index).getVar1());
            binding.var2.setText(quessionModelList.get(index).getVar2());
            binding.var3.setText(quessionModelList.get(index).getVar3());
            binding.var4.setText(quessionModelList.get(index).getVar4());
    }

    private void loadData() {
        quessionModelList = new ArrayList<>();
        if (laulage != null){
            switch (laulage) {
                case "Java":
                    List<QuessionModel> javaList = new ArrayList<>();
                    javaList.add(new QuessionModel("If qanday operator?", "Tanlov", "Shart", "Tip", "loop", "Shart"));
                    javaList.add(new QuessionModel("Boolean qanday qiymat saqlaydi", "true", "false", "massiv", "true va false", "true va false"));
                    javaList.add(new QuessionModel("Classdan obyekt olinami ? yoki Obyektdan", "Obyektdan class", "Classdan obyekt olinadi", "Noma'lum", "Bu yerda to'g'ri javob berilmagan", "Classdan obyekt olinadi"));
                    javaList.add(new QuessionModel("String tip o'zgaruvchi to'gri e'lon qilingan qatorni toping", "String name = \"John\"", "String name = 'John'", "string name = \"John\"", "String name = John", "String name = \"John\""));
                    javaList.add(new QuessionModel("Javada \"Scanner\" klassi nima uchun ishlatiladi?", "Ma'lumotlar bazasida ma'lumotlarni saqlash uchun.", "Foydalanuvchi kiritgan ma'lumotni olish uchun", "Tarmoq orqali ma'lumotlarni yuborish uchun.", "Faylga ma’lumotlarni yozish uchun.", "Foydalanuvchi kiritgan ma'lumotni olish uchun"));
                    javaList.add(new QuessionModel("Java tilida \"int\" tipi qanday qiymat saqlaydi?", "Belgilar ketma-ketligini saqlaydi", "Raqamli qiymatlarni saqlaydi", "Haqiqiy yoki False qiymatlarni saqlaydi", "Ob'ektlarga havolalarni saqlaydi", "Raqamli qiymatlarni saqlaydi"));
                    javaList.add(new QuessionModel("Java tilida \"char\" tipi qanday qiymat saqlaydi?", "Bitta belgini saqlaydi", "Butun son saqlaydi", "Tarmoq orqali ma'lumotlarni yuborish uchun.", "Faylga ma’lumotlarni yozish uchun.", "Bitta belgini saqlaydi"));
                    javaList.add(new QuessionModel("Java tilida \"float\" tipi qanday qiymat saqlaydi?", "Belgilar ketma-ketligini saqlaydi", "Haqiqiy sonlarni saqlaydi", "Tarmoq orqali ma'lumotlarni yuborish uchun.", "Faylga ma’lumotlarni yozish uchun.", "Haqiqiy sonlarni saqlaydi"));
                    javaList.add(new QuessionModel("Int tipidan kichik tipni toping !", "Long", "Byte", "Short", "B va C", "Short"));
                    javaList.add(new QuessionModel("Javada barcha classlarning ota classini nomini toping !", "Long", "String", "Int", "Object", "Object"));
                    Collections.shuffle(javaList);
                    quessionModelList = javaList;
                    break;
                case "Database":
                    List<QuessionModel> databaseList = new ArrayList<>();
                    databaseList.add(new QuessionModel("DataBaseda qo'shish amali to'g'ri yozilgan qatorni toping ?","INSERT INTO student name = 'name', age = '00', phone = '+998955995'","INSERT INTO student (name, age, phone) VALUES ('name','00','+998955995')","INSERT INTO student VALUES (name, age, phone)  ('name','00','+998955995')","INSERT INTO student ('name','00','+998955995') VALUES (name, age, phone)  ","INSERT INTO student (name, age, phone) VALUES ('name','00','+998955995')"));
                    databaseList.add(new QuessionModel("Biz Androidda DataBase ma'lumotlarni saqlaganda qaysi turidan foydalanamiz ?", "SQLite", "MySQL", "A va B", "Men bilmayman", "SQLite"));
                    databaseList.add(new QuessionModel("DataBaseda ma'lumotlarni qay ko'rinishda saqlaydi ?", "List", "Jadval", "Recuest", "Respons", "Jadval"));
                    databaseList.add(new QuessionModel("DataBaseda \";\" bu amalni qo'llasa bo'ladimi ?", "Ha", "Yo'q", "Bazan", "Mutlaqo", "Bazan"));
                    databaseList.add(new QuessionModel("DataBaseda ma'lumotlarni o'chirish to'g'ri yozilgan qatorni toping ?", "DELETE * FROM student WHERE id = '1'", "DELETE  FROM student WHERE id = 1", "DELETE student WHERE id = '1'", "DELETE  FROM student WHERE id = '1'", "DELETE  FROM student WHERE id = '1'"));
                    databaseList.add(new QuessionModel("DataBaseda ma'lumotlarni o'zgartirish to'g'ri yozilgan qatorni toping ?", "UPDATE student SET name = 'name', age = '00', phone = '+998955995' WHERE id = '1'", "UPDATE FROM student SET name = 'name', age = '00', phone = '+998955995' WHERE id = '1'", "UPDATE * FROM student SET name = 'name', age = '00', phone = '+998955995' WHERE id = '1'", "UPDATE * FROM student SET name = 'name', age = '00', phone = '+998955995' id = '1'", "UPDATE student SET name = 'name', age = '00', phone = '+998955995' WHERE id = '1'"));
                    databaseList.add(new QuessionModel("DataBaseda barcha ma'lumotlarni  chiqarilgan qatorni toping ?", "SELECT * FROM student", "SELECT * FROM", "SELECT * student", "SELECT FROM student", "SELECT * FROM student"));
                    databaseList.add(new QuessionModel("DataBaseda bitta ma'lumotni  chiqarilgan qatorni toping ?", "SELECT * FROM student", "SELECT * FROM student WHERE id = '1'", "SELECT * FROM student WHERE = '1'", "SELECT FROM student WHERE id = '1'", "SELECT * FROM student WHERE id = '1'"));
                    databaseList.add(new QuessionModel("DataBaseda min to'g'ri yozilgan  qatorni toping ?", "SELECT min(age) FROM student WHERE 14", "SELECT min(student) FROM age WHERE 14", "SELECT min(age) FROM * WHERE 14", "SELECT min(14) FROM student WHERE age", "SELECT min(age) FROM student WHERE 14"));
                    databaseList.add(new QuessionModel("DataBaseda max to'g'ri yozilgan  qatorni toping ?", "SELECT max(age) FROM student WHERE 14", "SELECT max(student) FROM age WHERE 14", "SELECT max(age) FROM * WHERE 14", "SELECT max(14) FROM student WHERE age", "SELECT max(age) FROM student WHERE 14"));
                    Collections.shuffle(databaseList);
                    quessionModelList = databaseList;
                    break;
                case "Android":
                    List<QuessionModel> androidList = new ArrayList<>();
                    androidList.add(new QuessionModel("Intent bilan nima qilamiz ?", "Activityga ma'lumot ham olib o'tamiz", "Bu bir siykl", "Boshqa activityga o'tamiz", "Saqlaymiz", "Activityga ma'lumot ham olib o'tamiz"));
                    androidList.add(new QuessionModel("Shared Preferences bilan nima qilamiz ?", "Activityga ma'lumot ham olib o'tamiz", "Ma'lumotlarni saqlaymiz", "Boshqa activityga o'tamiz", "Animatsiya qilamiz", "Ma'lumotlarni saqlaymiz"));
                    androidList.add(new QuessionModel("Edit text nima qiladi ?", "Edittextda biz yozgan ma'lumotni o'qishimiz mumkun", "O'zgaruvchilarni tekshiramiz", "Boshqa activityga o'tamiz", "Saqlaymiz", "Edittextda biz yozgan ma'lumotni o'qishimiz mumkun"));
                    androidList.add(new QuessionModel("Qaysi bir listsaqlaydigan view yaxshiroq ?", "ListView", "A va D", "No'malum", "RecycleView", "RecycleView"));
                    androidList.add(new QuessionModel("Listga qo'shganda Adapterni qaysi funksiyasidan foydalanish kerak ?", "adapter.notifyDataSetChanged();", "A va C", "adapter.notifyItemInserted();", "adapter.notifyItemRangeChanged();", "adapter.notifyItemInserted();"));
                    androidList.add(new QuessionModel("Rasmlarni internetdan yuklab olish uchun ko'pincha qaysi kutubxonadan foydalanish kerak", "Gson", "Pygame", "Picasso", "Navigation", "Picasso"));
                    androidList.add(new QuessionModel("ListViewda faqat Stringni saqlamoqchi bo'lsak qaysi adapterdan foydalanamiz ?", "Gson", "ArrayAdapter", "Glide", "Adapter", "ArrayAdapter"));
                    androidList.add(new QuessionModel("Listda ma'lumotni o'chirgandan so'ng qaysi metodlardan foydalanamiz ?", "notifyDataSetChanged();", "notifyItemRangeChanged()", "notifyItemRemoved() - notifyItemRangeChanged()", "notifyItemRemoved()", "notifyItemRemoved() - notifyItemRangeChanged()"));
                    androidList.add(new QuessionModel("Biz Androidda DataBase ma'lumotlarni saqlaganda qaysi turidan foydalanamiz", "SQLite", "MySQL", "A va B", "Men bilmayman", "SQLite"));
                    androidList.add(new QuessionModel("TextInputEditTextni chap tomonga qanday to'g'ri rasm qo'yiladi ?", "app:rightDrawable=\"\";", "app:leftDrawable=\"\"", "app:endIconDrawable=\"\"", "app:startIconDrawable=\"\"", "app:startIconDrawable=\"\""));
                    Collections.shuffle(androidList);
                    quessionModelList = androidList;
                    break;
                case "Kotlin":
                    List<QuessionModel> kotlinList = new ArrayList<>();
                    kotlinList.add(new QuessionModel("Varni Valdan nima farqi bor ?","Varda ochilgan o'zgaruvchilarni o'zgartirsa bo'ladi","Var bilan Valni oxirgi xarfida","Farqi yo'q","Bilmadim","Varda ochilgan o'zgaruvchilarni o'zgartirsa bo'ladi"));
                    kotlinList.add(new QuessionModel("Ko'tlinda classdan obyekt  olganda new kalit so'zi ishlatilami ?","Ha","No'malum","A","Yo'q","Yo'q"));
                    kotlinList.add(new QuessionModel("Kotlinda voris olganda superclass oldidan nima deb yozish kerak ?","data","open","Farqi yo'q","Bilmadim","open"));
                    kotlinList.add(new QuessionModel("Kotlinda voris olganda qaysi kalit so'zni yozish kerak ?","extends","implements",":","Bilmadim",":"));
                    kotlinList.add(new QuessionModel("Kotlinda oddiy metodlar oldidan nima deb yoziladi ?","extends","String","void","fun","fun"));
                    kotlinList.add(new QuessionModel("Kotlinda data classlardan voris olsa bo'ladimi ?","Ha","A va C","Yo'q","Bilmadim","Yo'q"));
                    kotlinList.add(new QuessionModel("Kotlinda metodni qiymat qaytaradigan qilish uchun qaytaradigan qiymatni qayeriga yozish kerak ?","metodni oldiga","metodni orqasiga","metodni o'rtasiga","Bilmadim","metodni orqasiga"));
                    kotlinList.add(new QuessionModel("O'zgaruvchining ortidan \";\" belgini qo'ysa bo'ladimi ?","Shart emas","Yo'q","Ha","Qo'yish shart","Shart emas"));
                    kotlinList.add(new QuessionModel("Kotlinda abstract classda abstract metod to'g'ri yozilgan qatorni toping !","abstract method","abstract fun method","abstract fun method()","fun method()","abstract fun method()"));
                    kotlinList.add(new QuessionModel("Kotlinda interface classda abstract metod to'g'ri yozilgan qatorni toping !","abstract fun method()","fun method()","metodni o'rtasiga","fun method","fun method()"));
                    Collections.shuffle(kotlinList);
                    quessionModelList = kotlinList;
                    break;
                default:
                    Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();
            }
        }
    }
}