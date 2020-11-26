public class Authorization { // Авторизация
    public static void author(){ // запускается первым, проверка наличия сеанса
        String session = FileScan.getSession();
        if (session.equals("")){
            page();
        }else{
            int perm = DataServer.SessionCheck(session);
            if (perm == 0){
                mainPage.starting();
            }else{
                page();
            }
        }
    }

    public static void page() { // Основное окно

    }

    public static void login(){ // Окно входа

    }

    public static void regist(){ // Окно регестрации

    }

    public static void gosUsl(){ // Окно входа через ГосУслуги

    }
}
