package fun.epoch.learn.design.pattern.creational.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail originMail = new Mail("恭喜 %s 同学，您中奖了！");

        for (int i = 0; i < 3; i++) {
            // 由于创建 Mail 对象时，初始化 configurations 属性十分消耗资源，因此在循环中重复创建 Mail 对象会造成严重的性能问题
            // Mail mail = new Mail();
            // 由于使用 Mail 对象时只需修改部分简单属性，然后复用其余复杂的属性 (configurations)
            // 因此可以使用 原型模式 直接克隆 Mail 对象，从而避免重复创建对象时执行不必要的初始化
            Mail mail = originMail.clone();

            mail.setName("epoch" + (i + 1));
            mail.setAddress(mail.getName() + "@gmail.com");
            mail.setContent(String.format(originMail.getContent(), mail.getName()));

            MailUtils.sendMail(mail);
        }

        MailUtils.saveMailOriginContent(originMail);
    }
}
