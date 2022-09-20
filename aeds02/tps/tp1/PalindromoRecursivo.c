#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAXTAM 1000
#define true 1
#define false 0

int isFim(char* str);
char** getEntrada(char** entrada, int index);
void imprimir(char** saida, int index);
char** getPalindromo(char** entrada, int index);
int isPalindromo(char* entrada, int primeiro, int ultimo);

char** getPalindromo(char** entrada, int index) {
	if(isFim(entrada[index]) != true) {
		if(isPalindromo(entrada[index], 0, (int)strlen(entrada[index]) - 2) == true) {
			strcpy(entrada[index], "SIM"); 
		} else {
			strcpy(entrada[index], "NAO"); 
		}

		entrada = getPalindromo(entrada, index + 1);
	}
	return entrada;
}

int isPalindromo(char* entrada, int primeiro, int ultimo) {
	int resp = true;
	if(primeiro < (int)strlen(entrada) - 1) {
		if(entrada[primeiro] == entrada[ultimo]) {
			//printf("SIM: %c --- %c\n", entrada[primeiro], entrada[ultimo]);
			resp = isPalindromo(entrada, primeiro + 1, ultimo - 1);
		} else {
			//printf("NAO: %c --- %c\n", entrada[primeiro], entrada[ultimo]);
			resp = false;
			primeiro = (int)strlen(entrada);
		}
	}
	return resp;	
} 

char** getEntrada(char** entrada, int index) {
	entrada[index] = (char*) malloc(MAXTAM * sizeof(char));
	fgets(entrada[index], MAXTAM, stdin);
	if(isFim(entrada[index]) != true) {
		entrada = getEntrada(entrada, index + 1);
	}
	return entrada;
}

void imprimir(char** entrada, int index) {
	if(isFim(entrada[index]) != true) {
		printf("%s\n", entrada[index]);
		imprimir(entrada, index + 1);
	}
}

int isFim(char* str) {
	return (int)strlen(str) == 4 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' && str[3] == '\n';
}

int main() {
	char** entrada = (char**) malloc(MAXTAM * sizeof(char*));
	char** saida = (char**) malloc(MAXTAM * sizeof(char*));

	entrada = getEntrada(entrada, 0);
	saida = getPalindromo(entrada, 0);
	imprimir(saida, 0);

	return 0;
}
