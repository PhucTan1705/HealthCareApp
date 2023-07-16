package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
            {"Paracetamol Phapharco 500mg (10x10)", "", "", "", "34000"},
            {"Thuốc giảm đau Alaxan (25x4)", "", "", "", "129000"},
            {"Oresol 3B (20x4.1g)", "", "", "", "42000"},
            {"PLoratadin 10mg (2x10)", "", "", "", "20000"},
            {"GazGo 200mg (3x10)", "", "", "", "180000"},
            {"Fexophar 60mg (5x10)", "", "", "", "95000"},
            {"Stugeron 25mg (25x10)", "", "", "", "250000"},
            {"Cao dán Salonpas (24x10)", "", "", "", "312000"},
            {"Sis-Bone (10x10)", "", "", "", "485000"},
    };
    private String[] packages_details ={
            "Điều trị cơn đau từ nhẹ đến vừa bao gồm: đau đầu, đau nửa đầu, đau cơ, đau bụng kinh, đau họng, đau cơ xương, sốt và đau sau khi tiêm vắc xin, đau sau khi nhổ răng hoặc sau các thủ thuật nha khoa, đau răng, đau do viêm khớp.\n"+
                    "Hạ sốt.",
            "Giảm các cơn đau cơ xương nhẹ đến trung bình như đau cổ, đau vai, đau lưng, căng cơ bắp tay hoặc bắp chân, cứng cơ cổ, viêm khớp, thấp khớp, viêm bao hoạt dịch, bong gân, viêm gân.\n"+
                    "Giảm nhức đầu, đau bụng kinh, nhức răng, đau sau nhổ răng và tiểu phẫu.",
            "Phòng và điều trị mất điện giải và muối trong tiêu chảy cấp từ nhẹ đến vừa.\n"+
                    "Bù nước và điện giải trong các trường hợp mất nước khác: nôn mửa, sốt cao, sốt xuất huyết, hoạt động thể lực.",
            "Trị viêm mũi dị ứng.\n"+
                    "Trị Viêm kết mạc dị ứng.\n"+
                    "Trị ngứa và mày đay liên quan đến histamin.",
            "Điều trị các triệu chứng liên quan đến tích tụ hơi (ở vùng dạ dày ruột) như là khó chịu hoặc căng đau, trướng bụng và đầy hơi.\n"+
                    "Được dùng dưới dạng liệu pháp hỗ trợ trong nhiều trường hợp mà việc tích tụ hơi có thể gây nên các vấn đề như là ứ hơi sau phẫu thuật, chứng nuốt hơi, chứng khó tiêu chức năng, loét tiêu hóa, ruột kết khó chịu hoặc bị co thắt mạnh hoặc viêm túi thừa.",
            "Điều trị các triệu chứng viêm mũi dị ứng: sổ mũi, hắt hơi, viêm họng (ngứa và đỏ cổ họng).\n"+
                    "Trị dị ứng da, nổi mày đay.",
            "Điều trị duy trì các triệu chứng có nguồn gốc mạch máu não, bao gồm chóng mặt, ù tai, đau đầu mạch máu, những rối loạn kiểu dễ bị kích thích và khó gần, mất trí nhớ và thiếu tập trung.\n"+
                    "Điều trị duy trì các triệu chứng của rối loạn mê đạo, bao gồm chóng mặt, choáng váng, ù tai, rung giật nhãn cầu, buồn nôn và nôn.\n"+
                    "Điều trị duy trì các triệu chứng của rối loạn tuần hoàn ngoại vi, bao gồm hiện tượng Raynaud, chứng xanh tím đầu chi, khập khiễng cách hồi, rối loạn dinh dưỡng, loét do dinh dưỡng và giãn tĩnh mạch, dị cảm, chuột rút về đêm, lạnh đầu chi.\n"+
                    "Phòng ngừa say tàu xe.",
            "Người lớn và trẻ em từ 12 tuổi trở lên: Dùng giảm đau, kháng viêm trong các cơn đau liên quan đến: đau vai, đau lưng, đau cơ, mỏi cơ, đau khớp, bầm tím, bong gân, căng cơ, đau đầu, đau răng.\n"+
                    "Trẻ dưới 12 tuổi: Phải hỏi ý kiến Bác sĩ trước khi sử dụng.",
            "Bổ sung Calcium cho cơ thể ở người lớn tuổi, phụ nữ sau mãn kinh (phòng & điều trị loãng xương, giảm đau nhức), phụ nữ có thai & cho con bú, trẻ đang lớn (tăng chiều cao, trị còi xương, suy dinh dưỡng), bệnh nhân gãy xương (giúp mau lành xương)."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;

    ImageView VTBack,VTcart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_activity);

        lst=findViewById(R.id.listViewBM);
        VTBack=findViewById(R.id.VTBackBM);
        VTcart=findViewById(R.id.VTCartBM);

        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity2.class));
            }
        });

        VTcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list=new ArrayList();
        for (int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Giá:"+packages[i][4]+" VND");
            list.add(item);
        }

        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines2,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BMDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}