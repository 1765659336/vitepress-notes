public class Mandatory {
	public static void main(String[] args){
		int i = (int)1.9;
		System.out.println(i);//1
		/*
			ǿ������ת����ֻ�������Ĳ�������Ч,������ʹ��()�������ȼ�
		*/
		// int x = (int) 10.0/4+3.0;// ������Ϊintֻ��ת��10.0/4��ֵ,3.0��double����,����Զ�����ת��ֵ�����ͻ���double����
		int x2 = (int)(10.0/4 + 3);
		System.out.println(x2);//40
		/*
			char���Ϳ��Ա���int�ĳ���ֵ,�����ܱ���int�ı���ֵ
		*/
		char c1 = 100;
		int m = 100;
		// char c2 = m; // ����
		char c3 = (char)m;
		System.out.println(c1+"-"+c3);
	}
}