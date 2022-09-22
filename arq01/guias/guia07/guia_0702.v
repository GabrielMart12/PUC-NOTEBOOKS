module mux(output w, input x, input y, input e);
	wire ne, orxy, norxy, amux1, amux2;
	
	not   NOT1 (ne, e);

	or    OR1  (orxy, x, y);
	nor   NOR1 (norxy, x, y);
	
	and   AND1 (amux1, orxy, ne);
	and   AND2 (amux2, norxy, e);

	or    OR2  (w, amux1, amux2);
endmodule // mux

module guia_0702;
	reg x, y, e;
	wire w;

	mux MUX1 (w, x, y, e);

	initial begin : start
		x = 1'b0; y = 1'b0; e = 1'b0;
	end // start

	initial begin : main
		$display("x y e w");
		#1 $monitor("%b %b %b %b", x, y, e, w);
		#1 x = 1'b0; y = 1'b0; e = 1'b1;
		#1 x = 1'b0; y = 1'b1; e = 1'b0;
		#1 x = 1'b0; y = 1'b1; e = 1'b1;
		#1 x = 1'b1; y = 1'b0; e = 1'b0;
		#1 x = 1'b1; y = 1'b0; e = 1'b1;
		#1 x = 1'b1; y = 1'b1; e = 1'b0;
		#1 x = 1'b1; y = 1'b1; e = 1'b1;
	end // main
endmodule
