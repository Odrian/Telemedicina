public class DataServer { // связь с сервером

    public static String[][] getData (String id){
        return new String[][] {
                {"666", "Me", "Hi", "17:28 10-12-2020"},
                {"andrei", "Andrei", "Hi", "17:28 10-12-2020"},
                {"666", "Me", "how are u?", "17:28 10-12-2020"},
                {"andrei", "Andrei", "Fine, 1 hour ago I won 100$ and I wont to byu ice cream, and u?", "17:29 10-12-2020"},
                {"666", "Me", "Sad, my grandmother dead", "17:29 10-12-2020"},
                {"andrei", "Andrei", "Its really sadly(", "17:30 10-12-2020"},
                {"666", "Me", "А почему мы на англиском разговариваем?", "17:32 10-12-2020"},
                {"andrei", "Andrei", "Незнаю", "17:33 10-12-2020"},
                {"666", "Me", "Пойдём завтра гулять", "17:33 10-12-2020"},
                {"andrei", "Andrei", "Давай в 3 у школы", "17:35 10-12-2020"},
                {"666", "Me", "ок", "17:36 10-12-2020"}
        };
    }

    public static String[][] getListMsg(){
        return new String[][] {
                {"andrei", "Fantasy talks", "andrei: Привет"},
                {"666", "for me", "Ты: ок"}
        };
    }

    public static void sendMsg(String msg, Object[] files){
    }
}
