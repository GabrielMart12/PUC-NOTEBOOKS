#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>

#define MAXTAM 1000
#define true 1
#define false 0

int isFim(char *str);
char* isSomenteVogal(char *str);
char* isSomenteConsoante(char *str);
char* isSomenteInteiro(char *str);
int getQtdPonto(char *str);
char* isSomenteReal(char *str);
char* verificarString(char *str);

int isFim(char *str) {
	return (int)strlen(str) == 4 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' && str[3] == '\n' ? true : false;
}

char* verificarString(char *str) {
	char *resp = (char*) malloc(MAXTAM * sizeof(char*)); 
	char *respVogal = (char*) malloc(MAXTAM * sizeof(char*));
	char *respConsoante = (char*) malloc(MAXTAM * sizeof(char*));
	char *respInteiro = (char*) malloc(MAXTAM * sizeof(char*));
	char *respReal = (char*) malloc(MAXTAM * sizeof(char*));
	
	respVogal = isSomenteVogal(str);
	respConsoante = isSomenteConsoante(str);
	respInteiro = isSomenteInteiro(str);
	respReal = isSomenteReal(str);

	strcat(resp, respVogal);
	strcat(resp, respConsoante);
	strcat(resp, respInteiro);
	strcat(resp, respReal);
	
	return resp;
}

char* isSomenteVogal(char *str) {
	char *vogais = (char*) malloc(MAXTAM * sizeof(char*));
	vogais = "aeiouAEIOUáéíóúÁÉÍÓÚãõÃÕâêôÂÔÊ \n";
	int cont = 0;
	
	for(int i = 0; i < (int)strlen(str); i++) {
		for(int j = 0; j < (int)strlen(vogais); j++) {
			if(str[i] == vogais[j]) cont++;
		}
	}

	return cont == (int)strlen(str) ? "SIM " : "NAO ";
}

char* isSomenteConsoante(char *str) {
	char *vogais = (char*) malloc(MAXTAM * sizeof(char*));
	vogais = "0123456789aeiouAEIOUáéíóúÁÉÍÓÚãõÃÕâêôÂÔÊ";
	int cont = 0;

	for(int i = 0; i < (int)strlen(str); i++) {
		for(int j = 0; j < (int)strlen(vogais); j++) {
			if(str[i] == vogais[j]) cont++;
		}
	}

	return cont == 0 ? "SIM " : "NAO ";
}

char* isSomenteInteiro(char *str) {
	char *inteiros = (char*) malloc(MAXTAM * sizeof(char*));
	inteiros = "-0123456789 \n";
	int cont = 0;

	for(int i = 0; i < (int)strlen(str); i++) {
		for(int j = 0; j < (int)strlen(inteiros); j++) {
			if(str[i] == inteiros[j]) cont++;
		}
	}

	return cont == (int)strlen(str) ? "SIM " : "NAO ";
}

char* isSomenteReal(char *str) {
	char *reais = (char*) malloc(MAXTAM * sizeof(char*));
	reais = "-0123456789,. \n";
	int cont = 0;
	int contPonto = getQtdPonto(str);

	for(int i = 0; i < (int)strlen(str); i++) {
		for(int j = 0; j < (int)strlen(reais); j++) {
			if(str[i] == reais[j]) {
				cont++;
			}
		}
	}

	return cont == (int)strlen(str) && contPonto <= 1? "SIM" : "NAO";
}

int getQtdPonto(char *str) {
	int cont = 0;
	for(int i = 0; i < (int)strlen(str); i++) {
		if(str[i] == '.' || str[i] == ',') {
			cont++;
		}
	}
	return cont;
}

int main() {
	setlocale(LC_ALL, "Portuguese_Brasil");
	char **entrada = (char**) malloc(MAXTAM * sizeof(char*));
	char **saida = (char**) malloc(MAXTAM * sizeof(char*));
	int numEntrada = 0;

	do {
		entrada[numEntrada] = (char*) malloc(MAXTAM * sizeof(char*));
		saida[numEntrada] = (char*) malloc(MAXTAM * sizeof(char*));

		entrada[numEntrada] = fgets(entrada[numEntrada], MAXTAM, stdin);
		saida[numEntrada] = verificarString(entrada[numEntrada]);
	} while(isFim(entrada[numEntrada++]) != true);
	numEntrada--;

	for(int i = 0; i < numEntrada; i++) {
		printf("%s\n", saida[i]);
	}
}
