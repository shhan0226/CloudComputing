package benchmark_v1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2) {
			int Size = Integer.parseInt(args[0]);
			int Loop = Integer.parseInt(args[1]);
			Benchmark_SAXPY bs = new Benchmark_SAXPY(Size, Loop);
		} else {
			System.out.println("please input [InputSize] and [Loop]  \nExample) $banch 1000000 1");
		}

		// ù��°�� �޸�ũ��, �ι�°�� �ݺ�Ƚ��

	}

}
