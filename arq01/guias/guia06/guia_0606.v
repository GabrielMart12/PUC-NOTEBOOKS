module f_com(output s, input x, input y, input w, input z);
	assign s = (~(~x | ~y | w) & ~(x & y & ~z)) | ~((y & w & z) | ~(x));
endmodule

module f_sim(output s, input x, input y, input w, input z);
	assign s = (~w & x) | (x & ~y & w) | (x & w & ~z);
endmodule



module guia_0606;
	reg x, y, w, z;
	wire com, sim;
	integer n = 0;
	
	f_com F_COM(com, x, y, w, z);
	f_sim F_SIM(sim, x, y, w, z);
	
	initial begin : start
		x = 1'b0;
		y = 1'b0;
		w = 1'b0;
		z = 1'b0;
	end
	
	initial begin : main
		$display(" n x y w z = c s");
		$monitor("%2d %b %b %b %b = %b %b", n, x, y, w, z, com, sim);
		#1 x = 0; y = 0; w = 0; z = 0; n = 00;
		#1 x = 0; y = 0; w = 0; z = 1; n = 01;
		#1 x = 0; y = 0; w = 1; z = 0; n = 02;
		#1 x = 0; y = 0; w = 1; z = 1; n = 03;
		#1 x = 0; y = 1; w = 0; z = 0; n = 04;
		#1 x = 0; y = 1; w = 0; z = 1; n = 05;
		#1 x = 0; y = 1; w = 1; z = 0; n = 06;
		#1 x = 0; y = 1; w = 1; z = 1; n = 07;
		#1 x = 1; y = 0; w = 0; z = 0; n = 08;
		#1 x = 1; y = 0; w = 0; z = 1; n = 09;
		#1 x = 1; y = 0; w = 1; z = 0; n = 10;
		#1 x = 1; y = 0; w = 1; z = 1; n = 11;
		#1 x = 1; y = 1; w = 0; z = 0; n = 12;
		#1 x = 1; y = 1; w = 0; z = 1; n = 13;
		#1 x = 1; y = 1; w = 1; z = 0; n = 14;
		#1 x = 1; y = 1; w = 1; z = 1; n = 15;
	end
endmodule
