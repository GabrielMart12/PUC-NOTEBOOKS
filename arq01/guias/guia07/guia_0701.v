module mux(output w, input x, input y, input e);
	wire andxy, nandxy, note, amux1, amux2;
	
	not  NOT1     (note, e);
	
	and  AND1     ( andxy, x, y);
	nand NAND1    (nandxy, x, y);
	
	and  AND2     (amux1, andxy , note);
	and  AND3     (amux2, nandxy, e);

	or   OR1      (w, amux1, amux2);
endmodule // mux

module guia_0701;
	reg x, y, e;
	wire w;

	mux MUX1(w, x, y, e);

	initial begin : start
		x = 1'b0; y = 1'b0; e = 1'b0;
	end // start

	initial begin : main
		$display("x y e w");
		$monitor("%b %b %b %b", x, y, e, w);
		#1 x = 1'b0; y = 1'b0; e = 1'b0;
		#1 x = 1'b0; y = 1'b0; e = 1'b1;
		#1 x = 1'b0; y = 1'b0; e = 1'b1;
		#1 x = 1'b0; y = 1'b1; e = 1'b0;
		#1 x = 1'b0; y = 1'b1; e = 1'b1;
		#1 x = 1'b1; y = 1'b0; e = 1'b0;
		#1 x = 1'b1; y = 1'b0; e = 1'b1;
		#1 x = 1'b1; y = 1'b1; e = 1'b0;
		#1 x = 1'b1; y = 1'b1; e = 1'b1;
	end // main

endmodule // guia_0701
