package Entity;

import CustomerService.CustomerService;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;





public class MyBot extends TelegramLongPollingBot {
static OperationProsecc operationProsecc;
static  Double amount;
    @Override
    public String getBotToken() {
        return "5514037857:AAGUymTJ63SGpHpc9aR2acNDTbEnWoLw7v0";
    }

    @Override
    public void onUpdateReceived(Update update) {




        SendMessage sendMessage=new SendMessage();

        if(update.hasCallbackQuery()) {

            CallbackQuery callbackQuery = update.getCallbackQuery();
            Message message1 = callbackQuery.getMessage();
            String data = callbackQuery.getData();

            String chatId = String.valueOf(message1.getChatId());

            if(data.equalsIgnoreCase(Constanta.s1)){

                sendMessage.setText("Dollar miqdorini kiriting: ");
                operationProsecc = OperationProsecc.START;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.s2)){
                sendMessage.setText("So'm miqdorini kiriting: ");
                operationProsecc = OperationProsecc.FINISH;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.s3)){
                sendMessage.setText("Yevro miqdorini kiriting: ");
                operationProsecc = OperationProsecc.YEVRO1;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.s21)){
                sendMessage.setText("So'm miqdorini kiriting: ");
                operationProsecc = OperationProsecc.YEVRO2;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.back1)){
                sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ? ");
                sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getEuro());
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.back2)){
                sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ? ");
                sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getRUbl());
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }
            else if(data.equalsIgnoreCase(Constanta.back)){
                sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ? ");
               sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getInlineDollar());
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.s4)){
                sendMessage.setText("Rubl miqdorini kiriting: ");
                operationProsecc = OperationProsecc.RUBL1;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }else if(data.equalsIgnoreCase(Constanta.s22)){
                sendMessage.setText("So'm miqdorini kiriting: ");
                operationProsecc = OperationProsecc.RUBL2;
                sendMessage.setChatId(chatId);
                sendMes(sendMessage);
            }

        }
       else   if(update.hasMessage()){


             Message message= update.getMessage();
             String chatId = String.valueOf(message.getChatId());
             Customer customer = CustomerService.getCustomerByChatid(chatId);
             String text = message.getText();

             if(text.equalsIgnoreCase("/start")){


                 sendMessage.setText("Assalomu alaykum. Botimizga xush kelibsiz." +
                         "Bu bot orqali siz valyuta kurslari haqida malumot olishingiz " +
                         "mumkin");



                 sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBaseMenu());
                 sendMessage.setChatId(chatId);

                 sendMes(sendMessage);



             }else if(text.equalsIgnoreCase(Constanta.BUTTON1)){

                    sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ?");
                    sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getInlineDollar());
                   sendMessage.setChatId(chatId);
                   sendMes(sendMessage);

             }else if(text.equalsIgnoreCase(Constanta.BUTTON2)){
                 sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ?");
                 sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getEuro());
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }else if(text.equalsIgnoreCase(Constanta.BUTTON3)){
                 sendMessage.setText("Qaysi operatsiyani bajarmoqchisiz ?");
                 sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getRUbl());
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }
             else if(operationProsecc==OperationProsecc.START){


               try {
                   amount=Double.parseDouble(text);
                   Double aDouble = CustomerService.checkDollar();
                   sendMessage.setText(text+" $ "+String.valueOf(aDouble*amount)+" so'm");
                   sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack());
                     operationProsecc=null;
                     amount=0.0;
               } catch (NumberFormatException e){
                sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                operationProsecc = OperationProsecc.START;

             }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
       }else if(operationProsecc==OperationProsecc.FINISH){
                 try {
                     amount=Double.parseDouble(text);
                     Double aDouble = CustomerService.checkDollar();
                     String s = SumService.doSum(String.valueOf(amount / aDouble));

                     sendMessage.setText(text+" so'm "+s+" $ ");
                     sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack());
                     operationProsecc=null;
                     amount=0.0;
                 } catch (NumberFormatException e){
                     sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                     operationProsecc = OperationProsecc.START;

                 }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }else if(operationProsecc==OperationProsecc.YEVRO1) {
                 try {
                     amount = Double.parseDouble(text);
                     Double aDouble = CustomerService.checkYevro();
                     sendMessage.setText(text + " EVRO " + String.valueOf(aDouble *amount) + " so'm");
                     sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack1());
                     operationProsecc = null;
                     amount = 0.0;
                 } catch (NumberFormatException e) {
                     sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                     operationProsecc = OperationProsecc.YEVRO1;

                 }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }
             else if(operationProsecc==OperationProsecc.YEVRO2) {
                 try {
                     amount = Double.parseDouble(text);
                     Double aDouble = CustomerService.checkYevro();
                     String s = SumService.doSum(String.valueOf((amount / aDouble)));
                     sendMessage.setText(text + " so'm " + s + " EVRO ");
                     sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack1());
                     operationProsecc = null;
                     amount = 0.0;
                 } catch (NumberFormatException e) {
                     sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                     operationProsecc = OperationProsecc.YEVRO2;

                 }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }else if(operationProsecc==OperationProsecc.RUBL1) {
                 try {
                     amount = Double.parseDouble(text);
                     Double aDouble = CustomerService.checkRubl();
                     sendMessage.setText(text + " RUBL " + String.valueOf(aDouble * amount) + " so'm");
                     sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack2());
                     operationProsecc = null;
                     amount = 0.0;
                 } catch (NumberFormatException e) {
                     sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                     operationProsecc = OperationProsecc.RUBL1;

                 }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             } else if(operationProsecc==OperationProsecc.RUBL2) {
                 try {
                     amount = Double.parseDouble(text);
                     Double aDouble = CustomerService.checkRubl();
                     String s = SumService.doSum(String.valueOf(amount / aDouble));
                     sendMessage.setText(text + " so'm " +s + " RUBL ");
                     sendMessage.setReplyMarkup(ReplyKeyBoardMarkupUtil.getBack2());
                     operationProsecc = null;
                     amount = 0.0;
                 } catch (NumberFormatException e) {
                     sendMessage.setText("Noto'g'ri kiritildi.Qayta kiriting.");
                     operationProsecc = OperationProsecc.RUBL2;

                 }
                 sendMessage.setChatId(chatId);
                 sendMes(sendMessage);
             }

       }

         else {

             sendMessage.setText("Noto'g'ri tanlov");
             sendMes(sendMessage);
         }


    }

    @Override
    public String getBotUsername() {
        return "t.me/CurrencYUzRusEngBot.";
    }

    public  void sendMes(SendMessage sendMessage){
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public  void sendMes(DeleteMessage deleteMessage){
        try {
            execute(deleteMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
