module op (output oand, output onand, output oor, output onor, input x, input y);
	and  OAND  (oand, x, y);
	nand ONAND (onand, x, y);
	or   OOR   (oor, x, y);
	nor  ONOR  (onor, x, y);
endmodule // op

module mux1 (output w, input x, input y, input e);
	wire andxy, nandxy, orxy, norxy, ne;
	wire and1, and2, and3, and4;

	op OP1    (andxy, nandxy, orxy, norxy, x, y);

	not NE1   (ne, e);
	
	and AND1  (and1, andxy, ne);
	and AND2  (and2, nandxy, e);
	and AND3  (and3, orxy, ne);
	and AND4  (and4, norxy, e);

	or  RESP1 (w, and1, and2, and3, and4);
endmodule // mux1

module mux2 (output w, input x, input y, input e);
	wire andxy, nandxy, orxy, norxy, ne;
	wire and1, and2, and3, and4;

	op OP2    (andxy, nandxy, orxy, norxy, x, y);

	not NE2   (ne, e);
	
	and AND5  (and1, andxy, ne);
	and AND6  (and2, nandxy, ne);
	and AND7  (and3, orxy, e);
	and AND8  (and4, norxy, e);

	or RESP2  (w, and1, and2, and3, and4);
endmodule // mux 2

module guia_0703;
	reg x, y, e;
	wire w1, w2;

	mux1 MUX1 (w1, x, y, e);
	mux2 MUX2 (w2, x, y, e);

	initial begin : start
		x = 1'b0; y = 1'b0; e = 1'b0;
	end // start

	initial begin : main
		$display("x y e 1 2");
		#1 $monitor("%b %b %b %b %b", x, y, e, w1, w2);
		
		#1 x = 1'b0; y = 1'b0; e = 1'b1;
		
		#1 $display("");

		#1 x = 1'b0; y = 1'b1; e = 1'b0;
		#1 x = 1'b0; y = 1'b1; e = 1'b1;

		#1 $display("");

		#1 x = 1'b1; y = 1'b0; e = 1'b0;
		#1 x = 1'b1; y = 1'b0; e = 1'b1;

		#1 $display("");

		#1 x = 1'b1; y = 1'b1; e = 1'b0;
		#1 x = 1'b1; y = 1'b1; e = 1'b1;
	end // main
endmodule // guia_0703
