module mux (output w, input x, input y, input e1, input e0);
	wire xorxy, xnorxy, orxy, norxy, wand1, wand2, wand3, wand4, ne1, ne0;

	not NOT1   (ne1, e1);
	not NOT0   (ne0, e0);

	xor  XOR1  (xorxy, x, y);
	xnor XNOR1 (xnorxy, x, y);
	or   OR1   (orxy, x, y);
	nor  NOR1  (norxy, x, y);

	and AND1   (wand1, xorxy, ne1, ne0);
	and AND2   (wand2, xnorxy, ne1, e0);
	and AND3   (wand3, orxy, e1, ne0);
	and AND4   (wand4, norxy, e1, e0);

	or  OR2    (w, wand1, wand2, wand3, wand4);
endmodule // mux

module guia_0704;
	reg x, y, e1, e0;
	wire w;

	mux MUX (w, x, y, e1, e0);

	initial begin : start
		x = 1'b0; y = 1'b0; e1 = 1'b0; e0 = 1'b0;
	end // start

	initial begin : main
		$display("x y 1 0 w");
		#1 $monitor("%b %b %b %b %b", x, y, e1, e0, w);
		#1 x = 1'b0; y = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b0; e1 = 1'b1; e0 = 1'b1;

		#1 x = 1'b0; y = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e1 = 1'b1; e0 = 1'b1;
	
		#1 x = 1'b1; y = 1'b0; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e1 = 1'b1; e0 = 1'b1;
			
		#1 x = 1'b1; y = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e1 = 1'b1; e0 = 1'b1;
	end // main
	
endmodule // guia_0704
