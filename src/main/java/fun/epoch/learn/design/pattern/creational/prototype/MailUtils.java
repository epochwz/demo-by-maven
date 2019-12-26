package fun.epoch.learn.design.pattern.creational.prototype;

public class MailUtils {
    public static void sendMail(Mail mail) {
        System.out.println(String.format("向 %s (%s) 同学发送邮件：%s\n", mail.getName(), mail.getAddress(), mail.getContent()));
    }

    public static void saveMailOriginContent(Mail mail) {
        System.out.println("保存邮件原始模板：" + mail.getContent());
    }
}
