public class Array<E> implements Deque<E> {

    public static final int CAPACITY = 1000;

    public Array() {
        this(CAPACITY);
    }

    private E[] Array;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public Array(int capacity) {
        this.capacity = capacity;
        this.Array = (E[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() { // This method returns true if the deque is full
        return size == capacity; // the number of elements (size) is equal to the maximum capacity
    }

    public boolean isEmpty() { // This method returns true if the deque is empty
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(E element) {
        if (isFull()) { // يشيك على المصفوفة مليانة أو لا
            throw new IllegalStateException("Deque is full");
        }
        front = ((front - 1) + capacity) % capacity;
        /*
           القوس الصغير يضمن لي أنه العنصر ينضاف في المقدمة "اليسار"
           القوس الكبير يضمن أن الاندكس ما يصير سالب لو كان اندكس الـ front صفر
           العلامة المئوية % تضمن أن المصفوفة ما حتطلع برا بتلف جوا حدودها
        */
        Array[front] = element; // أسند قيمة العنصر
        size++; // أزيد عدد عناصر المصفوفة بكل مرة أضيف
    }

    public void addLast(E element) {
        if (isFull()) { // يشيك على المصفوفة مليانة أو لا
            throw new IllegalStateException("Deque is full");
        }
        rear = (rear + 1) % capacity;
        Array[rear] = element; // أضيف العنصر في النهاية
        size++; // أزيد حجم المصفوفة
    }

    public E removeLast() {
        if (isEmpty()) { // يتحقق من المصفوفة إذا فاضية
            throw new IllegalStateException("Deque is empty"); // إذا كانت فاضية يرسل استثناء
        }
        E element = Array[rear]; // يحفظ العنصر الأخير المراد حذفه
        Array[rear] = null; // يفرغ المكان عشان الـ garbage collection
        if (front == rear) {
            front = rear = -1;
            /*
               إذا كانوا متساويين يدل على أنه لا يوجد إلا عنصر واحد فقط فنسند القيمتين
               إلى سالب واحد حتى تصبح المصفوفة فارغة وينحذف العنصر
            */
        } else {
            rear = (rear - 1 + capacity) % capacity; // decrement دائري
        }
        size--; // أنقص عدد العناصر
        return element; // يرجع العنصر اللي انحذف
    }

    public E removeFirst() {
        if (isEmpty()) { // يتحقق من المصفوفة إذا فاضية
            throw new IllegalStateException("Deque is empty"); // إذا كانت فاضية يرسل استثناء
        }
        E element = Array[front]; // يحفظ العنصر الأول المراد حذفه
        Array[front] = null; // يفرغ المكان عشان الـ garbage collection
        if (front == rear) {
            front = rear = -1;
            /*
               إذا كانوا متساويين يدل على أنه لا يوجد إلا عنصر واحد فقط فنسند القيمتين
               إلى سالب واحد حتى تصبح المصفوفة فارغة وينحذف العنصر
            */
        } else {
            front = (front + 1) % capacity; // increment دائري
        }
        size--; // أنقص عدد العناصر
        return element; // يرجع العنصر اللي انحذف
    }

    public E first() {
        if (isEmpty()) { // يتحقق من المصفوفة إذا فاضية
            throw new IllegalStateException("Deque is empty"); // إذا كانت فاضية يرسل استثناء
        }
        return Array[front]; // يرجع أول عنصر
    }

    public E last() {
        if (isEmpty()) { // يتحقق من المصفوفة إذا فاضية
            throw new IllegalStateException("Deque is empty"); // إذا كانت فاضية يرسل استثناء
        }
        return Array[rear]; // يرجع آخر عنصر
    }

    public void traverse() {
        if (isEmpty()) { // يشيك لو كانت المصفوفة فارغة
            System.out.println("The Array is empty.");
            return;
        }
        System.out.print("Elements in the Array: ");
        int current = front; // ابدأ من المؤشر الأمامي
        for (int i = 0; i < size; i++) {
            System.out.print(Array[current] + " "); // يطبع العنصر الحالي
            current = (current + 1) % capacity; // انتقل إلى العنصر التالي بشكل دائري
        }
        System.out.println();
    }
}