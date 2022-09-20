module f_ex01(output s, input A, input B, input C);
	assign s = (~A | B) & (~A | ~C);
endmodule

module f_ex02(output s, input A, input B, input C);
	assign s = (A | B | ~C) & (~A | ~B); 
endmodule

module f_ex03(output s, input A, input B, input C);
	assign s = (A | ~C) & (A | ~B) & (~B | C); 
endmodule

module f_ex04(output s, input A, input B, input C);
	assign s = (~A | ~C) & (~B | ~C) & (A | B | C);
endmodule

module f_ex05(output s, input A, input B, input C);
	assign s = (A | ~C) & (~A | ~B) & (~B | ~C);
endmodule

module guia_0602;
	reg a, b, c;
	wire ex01, ex02, ex03, ex04, ex05;
	
	f_ex01 F_EX01(ex01, a, b, c);
	f_ex02 F_EX02(ex02, a, b, c);
	f_ex03 F_EX03(ex03, a, b, c);
	f_ex04 F_EX04(ex04, a, b, c);
	f_ex05 F_EX05(ex05, a, b, c);
	
	initial begin : start
		a = 1'b0;
		b = 1'b0;
		c = 1'b0;
	end
	
	initial begin : main
		$display("A B C = 1 2 3 4 5");
		$monitor("%b %b %b = %b %b %b %b %b", a, b, c, ex01, ex02, ex03, ex04, ex05);
		#1 a = 0; b = 0; c = 0;
		#1 a = 0; b = 0; c = 1;
		#1 a = 0; b = 1; c = 0;
		#1 a = 0; b = 1; c = 1;
		#1 a = 1; b = 0; c = 0;
		#1 a = 1; b = 0; c = 1;
		#1 a = 1; b = 1; c = 0;
		#1 a = 1; b = 1; c = 1;
	end
endmodule
