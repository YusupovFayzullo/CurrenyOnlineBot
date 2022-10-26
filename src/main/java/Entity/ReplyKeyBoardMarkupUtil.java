package Entity;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyBoardMarkupUtil {
   public static ReplyKeyboardMarkup getBaseMenu(){

       KeyboardButton button1=new KeyboardButton();
       button1.setText(Constanta.BUTTON1);


       KeyboardButton button2=new KeyboardButton();
       button2.setText(Constanta.BUTTON2);

       KeyboardButton button3=new KeyboardButton();
       button3.setText(Constanta.BUTTON3);

       KeyboardRow row1=new KeyboardRow();


       row1.addAll(List.of(button2,button3));

       KeyboardRow row2=new KeyboardRow();
       row2.add(button1);

       ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();

       replyKeyboardMarkup.setKeyboard(List.of(row1,row2));
       replyKeyboardMarkup.setResizeKeyboard(true);
       replyKeyboardMarkup.setSelective(true);
       replyKeyboardMarkup.setOneTimeKeyboard(true);
       return replyKeyboardMarkup;
   }
   public static InlineKeyboardMarkup getInlineDollar(){

       InlineKeyboardButton button1=new InlineKeyboardButton();

       button1.setText("DOLLAR dan SUM ga o'tish");
       button1.setCallbackData("dollar");

       InlineKeyboardButton button2=new InlineKeyboardButton();
       button2.setText("SUM dan DOLLAR ga o'tish");
       button2.setCallbackData("sum");
       List<InlineKeyboardButton> row=new ArrayList<>();
       row.add(button1);
       row.add(button2);
       List<List<InlineKeyboardButton>> rows=new ArrayList<>();

       rows.add(row);
       InlineKeyboardMarkup markup=new InlineKeyboardMarkup();
       markup.setKeyboard(rows);

       return markup;




   }

    public static InlineKeyboardMarkup getBack() {
        InlineKeyboardButton button=new InlineKeyboardButton();
        button.setText("Orqaga qaytish");
        button.setCallbackData("BACK");
        List<InlineKeyboardButton> row=new ArrayList<>();
        row.add(button);

        List<List<InlineKeyboardButton>> rows=new ArrayList<>();

        rows.add(row);

        InlineKeyboardMarkup markupBack=new InlineKeyboardMarkup();
        markupBack.setKeyboard(rows);

        return markupBack;
    }

    public static InlineKeyboardMarkup getEuro() {
        InlineKeyboardButton button1=new InlineKeyboardButton();

        button1.setText("YEVRO dan SUM ga o'tish");
        button1.setCallbackData("yevro");

        InlineKeyboardButton button2=new InlineKeyboardButton();
        button2.setText("SUM dan YEVRO ga o'tish");
        button2.setCallbackData("sumyevro");
        List<InlineKeyboardButton> row=new ArrayList<>();
        row.add(button1);
        row.add(button2);
        List<List<InlineKeyboardButton>> rows=new ArrayList<>();

        rows.add(row);
        InlineKeyboardMarkup markup=new InlineKeyboardMarkup();
        markup.setKeyboard(rows);

        return markup;


    }

    public static InlineKeyboardMarkup getRUbl() {
        InlineKeyboardButton button1=new InlineKeyboardButton();

        button1.setText("RUBL dan SUM ga o'tish");
        button1.setCallbackData("rubl");

        InlineKeyboardButton button2=new InlineKeyboardButton();
        button2.setText("SUM dan RUBL ga o'tish");
        button2.setCallbackData("sumrubl");
        List<InlineKeyboardButton> row=new ArrayList<>();
        row.add(button1);
        row.add(button2);
        List<List<InlineKeyboardButton>> rows=new ArrayList<>();

        rows.add(row);
        InlineKeyboardMarkup markup=new InlineKeyboardMarkup();
        markup.setKeyboard(rows);

        return markup;

    }

    public static InlineKeyboardMarkup getBack1() {
        InlineKeyboardButton button=new InlineKeyboardButton();
        button.setText("Orqaga qaytish");
        button.setCallbackData("BACK1");
        List<InlineKeyboardButton> row=new ArrayList<>();
        row.add(button);

        List<List<InlineKeyboardButton>> rows=new ArrayList<>();

        rows.add(row);

        InlineKeyboardMarkup markupBack=new InlineKeyboardMarkup();
        markupBack.setKeyboard(rows);

        return markupBack;
    }
    public static InlineKeyboardMarkup getBack2() {
        InlineKeyboardButton button=new InlineKeyboardButton();
        button.setText("Orqaga qaytish");
        button.setCallbackData("BACK2");
        List<InlineKeyboardButton> row=new ArrayList<>();
        row.add(button);

        List<List<InlineKeyboardButton>> rows=new ArrayList<>();

        rows.add(row);

        InlineKeyboardMarkup markupBack=new InlineKeyboardMarkup();
        markupBack.setKeyboard(rows);

        return markupBack;
    }
}
