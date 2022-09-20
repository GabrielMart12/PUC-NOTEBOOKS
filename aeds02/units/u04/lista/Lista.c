#include<stdio.h>
#include<stdlib.h>

#define MAXTAM 6

void inserirInicio(int x);
void inserirFim(int x);
void inserir(int x, int pos);
void mostrar();

int n;
int arr[MAXTAM];

void start() {
	n = 0;
}

void inserirInicio(int x) {
	int i;
	if(n >= MAXTAM) {
		exit(1);
	}
	for(i = n; i > 0; i--) {
		arr[i] = arr[i - 1];
	}
	arr[0] = x;
	n++;
}

void inserirFim(int x) {
	if(n >= MAXTAM) {
		exit(1);
	}
	arr[n] = x;
	n++;
}

void inserir(int x, int pos) {
	int i;
	if(n >= MAXTAM || pos > n || pos < 0) {
		exit(1);
	}
	for(i = n; i > pos; i--) {
		arr[i] = arr[i - 1];
	}
	arr[pos] = x;
	n++;
}

int removerInicio() {
	int i, resp;
	if(n == 0) {
		exit(1);
	}
	resp = arr[0];
	n--;
	for(i = 0; i < n; i++) {
		arr[i] = arr[i + 1];
	}
	return resp;
}

int removerFim() {
	int resp;
	if(n == 0) {
		exit(1);
	}
	return arr[--n];
}

int remover(int pos) {
	int i, resp;
	if(n == 0 || pos > n || pos < 0) {
		exit(1);
	}
	resp = arr[pos];
	n--;
	for(i = pos; i < n; i++) {
		arr[i] = arr[i + 1];
	}
	return resp;
}

void mostrar() {
	int i;
	printf("[ ");
	for(i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
	printf("]");
}

int main() {
	int w1, w2, w3;

	start();
	inserirInicio(4);
	inserirFim(6);
	w1 = removerInicio();
	inserirFim(3);
	inserirInicio(7);
	inserir(1, 1);
	w2 = removerFim();
	w3 = remover(2);
	mostrar();
	printf("\nw1 = %d; w2 = %d; w3 = %d;\n", w1, w2, w3);
	return 0;
}
