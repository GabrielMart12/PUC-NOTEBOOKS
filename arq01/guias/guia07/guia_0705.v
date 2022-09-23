module mux (output w, input x, input y, input e2, input e1, input e0);
	wire ne2, ne1, ne0;
	wire nxy, andxy, nandxy, xorxy, xnorxy, orxy, norxy;
	wire and1, and2, and3, and4, and5, and6, and7;

	not  NOT2   (ne2, e2);
	not  NOT1   (ne1, e1);
	not  NOT0   (ne0, e0);

	not  NOTXY  (nxy, x);
	and  ANDXY  (andxy, x, y);
	nand NANDXY (nandxy, x, y);
	xor  XORXY  (xorxy, x, y);
	xnor XNORXY (xnorxy, x, y);
	or   ORXY   (orxy, x, y);
	nor  NORXY  (norxy, x, y);

	and  AND1   (and1, nxy, ne2, ne1, ne0);
	and  AND2   (and2, andxy, ne2, ne1, e0);
	and  AND3   (and3, nandxy, ne2, e1, ne0);
	and  AND4   (and4, xorxy, ne2, e1, e0);
	and  AND5   (and5, xnorxy, e2, ne1, ne0);
	and  AND6   (and6, orxy, e2, ne1, e0);
	and  AND7   (and7, norxy, e2, e1, ne0);

	or   RESP   (w, and1, and2, and3, and4, and5, and6, and7);
endmodule // mux

module guia_0705;
	reg x, y;
	reg e2, e1, e0;
	wire w;

	mux MUX (w, x, y, e2, e1, e0);

	initial begin : start
		x = 1'b0; y = 1'b0; e2 = 1'b0; e1 = 1'b0; e0 = 1'b0;
	end // start

	initial begin : main
		$display("x y 2 1 0 w");
		#1 $monitor("%b %b %b %b %b %b", x, y, e2, e1, e0, w);

		#1 x = 1'b0; y = 1'b0; e2 = 1'b0; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b0; e1 = 1'b1; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b0; e2 = 1'b1; e1 = 1'b1; e0 = 1'b1;
		
		#1 $display("");

		#1 x = 1'b0; y = 1'b1; e2 = 1'b0; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b0; e1 = 1'b1; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b0; y = 1'b1; e2 = 1'b1; e1 = 1'b1; e0 = 1'b1;

		#1 $display("");

		#1 x = 1'b1; y = 1'b0; e2 = 1'b0; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b0; e1 = 1'b1; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b0; e2 = 1'b1; e1 = 1'b1; e0 = 1'b1;

		#1 $display("");

		#1 x = 1'b1; y = 1'b1; e2 = 1'b0; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b0; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b0; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b0; e1 = 1'b1; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b1; e1 = 1'b0; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b1; e1 = 1'b0; e0 = 1'b1;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b1; e1 = 1'b1; e0 = 1'b0;
		#1 x = 1'b1; y = 1'b1; e2 = 1'b1; e1 = 1'b1; e0 = 1'b1;
	end // main

endmodule // guia_0705
