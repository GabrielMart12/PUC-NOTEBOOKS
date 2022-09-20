module f_ex01(output s, input A, input B, input C, input D);
	assign s = (A | ~C | D) & (A | ~B | ~C) & (~A | ~B | C | ~D);
endmodule

module f_ex02(output s, input A, input B, input C, input D);
	assign s = (~A | B | C) & (~A | ~C | ~D) & (A | ~B | C | D);
endmodule


module f_ex03(output s, input A, input B, input C, input D);
	assign s = (~A | B | D) & (~A | ~C | D) & (A | ~B | C | D) & (~A | ~B | C | ~D);
endmodule

module f_ex04(output s, input A, input B, input C, input D);
	assign s = (~A | ~B | ~D) & (A | C | ~D) & (~A | ~B | ~C) & (A | B | ~C | D);
endmodule

module f_ex05(output s, input A, input B, input C, input D);
	assign s = (~C | ~D) & (A | ~B | ~D) & (A | ~B | ~C);
endmodule

module guia_0604;
	reg a, b, c, d;
	wire ex01, ex02, ex03, ex04, ex05;
	integer n = 0;
	
	f_ex01 F_EX01(ex01, a, b, c, d);
	f_ex02 F_EX02(ex02, a, b, c, d);
	f_ex03 F_EX03(ex03, a, b, c, d);
	f_ex04 F_EX04(ex04, a, b, c, d);
	f_ex05 F_EX05(ex05, a, b, c, d);
	
	initial begin : start
		a = 1'b0;
		b = 1'b0;
		c = 1'b0;
		d = 1'b0;
	end
	
	initial begin : main
		$display(" n A B C D = 1 2 3 4 5");
		$monitor("%2d %b %b %b %b = %b %b %b %b %b", n, a, b, c, d, ex01, ex02, ex03, ex04, ex05);
		#1 a = 0; b = 0; c = 0; d =0; n = 00;
		#1 a = 0; b = 0; c = 0; d =1; n = 01;
		#1 a = 0; b = 0; c = 1; d =0; n = 02;
		#1 a = 0; b = 0; c = 1; d =1; n = 03;
		#1 a = 0; b = 1; c = 0; d =0; n = 04;
		#1 a = 0; b = 1; c = 0; d =1; n = 05;
		#1 a = 0; b = 1; c = 1; d =0; n = 06;
		#1 a = 0; b = 1; c = 1; d =1; n = 07;
		#1 a = 1; b = 0; c = 0; d =0; n = 08;
		#1 a = 1; b = 0; c = 0; d =1; n = 09;
		#1 a = 1; b = 0; c = 1; d =0; n = 10;
		#1 a = 1; b = 0; c = 1; d =1; n = 11;
		#1 a = 1; b = 1; c = 0; d =0; n = 12;
		#1 a = 1; b = 1; c = 0; d =1; n = 13;
		#1 a = 1; b = 1; c = 1; d =0; n = 14;
		#1 a = 1; b = 1; c = 1; d =1; n = 15;
	end
endmodule
