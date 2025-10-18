

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(5);

        // إضافة عناصر إلى المصفوفة
        array.addLast(7);
        array.addFirst(4);
        array.addFirst(3);
        array.addFirst(1);
        array.addLast(9);

        System.out.println("All Elements after additions:");
        array.traverse(); // عرض جميع العناصر

        System.out.println("Is the Array Full? " + array.isFull());

        // عرض أول وآخر عنصر
        System.out.println("First Element: " + array.first());
        System.out.println("Last Element: " + array.last());


        // إزالة العناصر وعرض الحالة بعد كل عملية
        System.out.println("Remove The Last Element and The first Element: " + array.removeLast()+" ,"+ array.removeFirst());
        System.out.println("All Elements after removing:");
        array.traverse(); // عرض جميع العناصر


        // التحقق إذا كانت المصفوفة  فاضيه
        System.out.println("Is the Array Empty? " + array.isEmpty());

    }
}