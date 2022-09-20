module f_com(output s, input x, input y, input z);
	assign s = (~(~x | ~y) & ~(x & y)) | ~((y & z) | ~(x));
endmodule

module f_sim(output s, input x, input y, input z);
	assign s = (x & ~y) | (x & ~z);
endmodule



module guia_0605;
	reg x, y, z;
	wire com, sim;
	integer n = 0;
	
	f_com F_COM(com, x, y, z);
	f_sim F_SIM(sim, x, y, z);
	
	initial begin : start
		x = 1'b0;
		y = 1'b0;
		z = 1'b0;
	end
	
	initial begin : main
		$display(" n x y z = c s");
		$monitor("%2d %b %b %b = %b %b", n, x, y, z, com, sim);
		#1 x = 0; y = 0; z = 0; n = 00;
		#1 x = 0; y = 0; z = 1; n = 01;
		#1 x = 0; y = 1; z = 0; n = 02;
		#1 x = 0; y = 1; z = 1; n = 03;
		#1 x = 1; y = 0; z = 0; n = 04;
		#1 x = 1; y = 0; z = 1; n = 05;
		#1 x = 1; y = 1; z = 0; n = 06;
		#1 x = 1; y = 1; z = 1; n = 07;
	end
endmodule
