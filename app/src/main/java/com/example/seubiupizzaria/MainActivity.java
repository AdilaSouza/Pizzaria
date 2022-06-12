package com.example.seubiupizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public int calculateFunction(String taste, String size,
                                 HashMap<String,Integer> tasteHash,
                                 HashMap<String,Integer> sizeHash){
        int tasteValue = (Integer) tasteHash.get(taste);
        int sizeValue = (Integer) sizeHash.get(size);

        return(tasteValue + sizeValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // coisas da activity do android não apagar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adicionando os valores para depois usalos na funcao de calcular
        HashMap<String,Integer> tastesHashValues = new HashMap<>();
        tastesHashValues.put("Marquerita (R$ 20,00)", new Integer(20));
        tastesHashValues.put("Frango (R$ 30,00)", new Integer(30));
        tastesHashValues.put("Calabreza (R$ 40,00)", new Integer(40));
        tastesHashValues.put("Queijo (R$ 30,00)", new Integer(30));
        tastesHashValues.put("Portuguesa (R$ 40,00)", new Integer(40));

        HashMap<String,Integer> sizesHashValues = new HashMap<>();
        sizesHashValues.put("Pequeno (R$ 20,00)", new Integer(20));
        sizesHashValues.put("Média (R$ 30,00)", new Integer(30));
        sizesHashValues.put("Grande (R$ 40,00)", new Integer(40));

        // declarando os itens da view
        TextView textPersonPhone = findViewById(R.id.editTextPersonPhone);
        TextView textPersonName = findViewById(R.id.editTextPersonName);
        TextView textPersonAddress = findViewById(R.id.editTextPersonAddress);

        RadioGroup radioGroupPizzaSize = findViewById(R.id.radioGroupSize);
        RadioGroup radioGroupPizzaSelector = findViewById(R.id.radioGroupPizzaSelector);

        TextView textViewResult = findViewById(R.id.textViewResult);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        // criando acao do click p/ calculo do pedido
        buttonCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selectedSizeId = radioGroupPizzaSize.getCheckedRadioButtonId();
                RadioButton selectedSize = findViewById(selectedSizeId);
                String selectedSizeToString = (String) selectedSize.getText();

                int selectedTasteId = radioGroupPizzaSelector.getCheckedRadioButtonId();
                RadioButton selectedTaste = findViewById(selectedTasteId);
                String selectedTasteToString = (String) selectedTaste.getText();

                String message = "Você comprou uma pizza "
                        + selectedSizeToString + " de "
                        + selectedTasteToString
                        + " no valor de R$:"
                        + calculateFunction(selectedTasteToString,
                                            selectedSizeToString,
                                            tastesHashValues,
                                            sizesHashValues
                                            );

                textViewResult.setText(message);
            }
        });
    }
}