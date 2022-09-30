module meiaSoma (output s1, output s0, input a, input b);
	xor XOR1 (s0, a, b);
	and AND1 (s1, a, b);
endmodule // meiaSoma

module somaCompleta (output s1, output s0, input a, input b, input v);
	not NOT1 (s1, a);
	not NOT2 (s0, b);
endmodule // somaCompleta

module guia_0800;
	reg  [3:0] x;
	reg  [3:0] y;
	wire [3:0] v; // vai um
	wire [4:0] s;


endmodule // guia_0800
