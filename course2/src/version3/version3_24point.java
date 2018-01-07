package version3;




public class version3_24point {

	private double[] temp1 = new double[3];
	private double[] temp2 = new double[2];

	private double sum;

	
//	  cardArray : 52�����г�ȡ��4����
	 
	private int[] cardArray = new int[4];

	
//	  operator : ���������
	 
	private char[] operator = { '+', '-', '*', '/' };

	
//	 bcard : 4��ֽ�ƴ�������ֵ�����
	 
	private double[] scard = new double[4];


	private boolean isCorrect = false;

	public static void main(String[] args) {

		version3_24point nAnalyzePoker = new version3_24point();
		nAnalyzePoker.allResult();
	}

	public version3_24point() {

	}


	public static double calculate(double number1, double number2, char operator) {
		if (operator == '+') {
			return number1 + number2;
		} else if (operator == '-') {
			return number1 - number2;
		} else if (operator == '*') {
			return number1 * number2;
		} else if (operator == '/' && number2 != 0) {
			return number1 / number2;
		} else {
			return -1;
		}
	}

	public void search() {


		for (int i = 0; i < 4; i++) {


			for (int j = 0; j < 4; j++) {


				for (int k = 0; k < 4; k++) {

					// ���ȼ���������������֣�����3��������൱�����ŵ�����
					for (int m = 0; m < 3; m++) {
//						if (scard[m + 1] == 0 && operator[i] == '/') {
//							break;
//						}

						temp1[m] = calculate(scard[m], scard[m + 1], operator[i]);
						temp1[(m + 1) % 3] = scard[(m + 2) % 4];
						temp1[(m + 2) % 3] = scard[(m + 3) % 4];

						// ��ȷ�����ȼ�����������֣���������൱��ʣ������������˳�򴢴���temp1������
						// ��������ѡ���ȼ���������������֣�����������൱�ڵڶ�������
						for (int n = 0; n < 2; n++) {
//							if (temp1[n + 1] == 0 && operator[j] == '/') {
//								break;
//							}

							temp2[n] = calculate(temp1[n], temp1[n + 1],
									operator[j]);
							temp2[(n + 1) % 2] = temp1[(n + 2) % 3];

							// ��ȷ�����ȼ�����������֣���������൱��ʣ������������˳�򴢴���temp2������
							if (temp2[1] == 0 && operator[k] == '/') {
								break;
							}

							sum = calculate(temp2[0], temp2[1], operator[k]);

							if (sum == 24) {
								isCorrect = true;
								String expression = "";

								if (m == 0 && n == 0) {
									expression = "((" + (int) scard[0]
											+ operator[i] + (int) scard[1]
											+ ")" + operator[j]
											+ (int) scard[2] + ")"
											+ operator[k] + (int) scard[3]
											+ "=" + (int) sum;
								} else if (m == 0 && n == 1) {
									expression = "(" + (int) scard[0]
											+ operator[i] + (int) scard[1]
											+ ")" + operator[k] + "("
											+ (int) scard[2] + operator[j]
											+ (int) scard[3] + ")=" + (int) sum;
								} else if (m == 1 && n == 0) {
									expression = "(" + (int) scard[0]
											+ operator[j] + "("
											+ (int) scard[1] + operator[i]
											+ (int) scard[2] + "))"
											+ operator[k] + (int) scard[3]
											+ "=" + (int) sum;
								} else if (m == 2 && n == 0) {
									expression = "(" + (int) scard[0]
											+ operator[j] + (int) scard[1]
											+ ")" + operator[k] + "("
											+ (int) scard[2] + operator[i]
											+ (int) scard[3] + ")=" + (int) sum;
								} else if (m == 2 && n == 0) {
									expression = (int) scard[0] + operator[k]
											+ "(" + (int) scard[1]
											+ operator[j] + "("
											+ (int) scard[2] + operator[i]
											+ (int) scard[3] + "))="
											+ (int) sum;
								}

//								System.out.println(expression);//��ӡÿ�ֿ���
							}
						}
					}
				}
			}
		}
	}

	public void allResult() {
        System.out.println("�����С�����������");
        int allCount = 0;//�ܴ���
		int count = 0;//���Թ���24��Ĵ���
		for (int i = 1; i < 53; i++) {
			for (int j = i + 1; j < 53; j++) {
				for (int k = j + 1; k < 53; k++)
					for (int l = k + 1; l < 53; l++) {
						allCount++;
						if (isCorrectExpression(i, j, k, l)) {
							count++;
						}
					}
			}
		}
        System.out.println("�������");
		double rate = (double) count / allCount;
		System.out.println("���п��ܵ���Ϲ��У�" + allCount);
		System.out.println("���Ϊ24����Ϲ��У� " + count);
		System.out.println("�ɹ��ļ�����:" + rate);
	}

	
//	 ����4�����ж����ܲ������ٸ��������24����ʽ
	public boolean isCorrectExpression(int num1, int num2, int num3, int num4) {
		for (int a = 0; a < 4; a++)
			for (int b = 0; b < 4; b++) {
				if (b == a) {
					continue;
				}

				for (int c = 0; c < 4; c++) {
					if (c == a || c == b) {
						continue;
					}

					for (int d = 0; d < 4; d++) {
						if (d == a || d == b || d == c) {
							continue;
						}

						cardArray[a] = num1;
						cardArray[b] = num2;
						cardArray[c] = num3;
						cardArray[d] = num4;

						for (int m = 0; m < 4; m++) {
							scard[m] = (double) cardArray[m] % 13;
							if (cardArray[m] % 13 == 0) {
								scard[m] = 13;
							}
						}

						search();

						if (isCorrect) {
							isCorrect = false;
							return true;
						}
					}
				}
			}

		return false;
	}
}
