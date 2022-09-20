#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define true 1
#define false 0
#define MAXTAM 1000

typedef struct Games {
	int app_id;
	char* name;
	char* release_date;
	char* owners;
	int age;
	float price;
	int dlcs;
	char** languages;
	char* website;
	int windows_os;
	int mac_os;
	int linux_os;
	float upvotes;
	int avg_pt;
	char* developers;
	char** genres;

} Games;

int isFim(char* str);
int games_construtor(Games* game);
int isVirgula(char c);
int isAspas(char c);
int getNumVirgulas(char* str);
char** parseLanguages(char* str);
void ler(Games* game, char* id);
char* excluirBN(char* id);
char* formatReleaseDate(char* str);
char* formatLanguages(char** arr);
void imprimir(Games* game);


int isFim(char* str) {
	return (int)strlen(str) == 4 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' && str[3] == '\n';
}

int games_construtor(Games* game) {
	if(game == NULL) 
		return 0;
	game->app_id = 0;
	game->name = (char*) malloc(MAXTAM * sizeof(char*));
	game->release_date = (char*) malloc(MAXTAM * sizeof(char*));
	game->owners = (char*) malloc(MAXTAM * sizeof(char*));
	game->age = 0;
	game->price = 0.0;
	game->dlcs = 0;
	return 1;
}

void ler(Games* game, char* id) {
	FILE* fgames = fopen("./tmp/games.csv", "r");
	char* linha = (char*) malloc(MAXTAM * sizeof(char*));
	int index = 0;

	while(feof(fgames) != true) {
		fgets(linha, MAXTAM, fgames);
		if(strstr(linha, id))
			break;
	}

	// app_id
	char* app_id = (char*) malloc(MAXTAM * sizeof(char*));
	int index_app_id = 0;
	while(isVirgula(linha[index]) != true) {
		app_id[index_app_id] = linha[index];
		index_app_id++;
		index++;
	}
	index++;
	game->app_id = atoi(app_id);

	// name
	char* name = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_name = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				name[index_name] = linha[index];
				index_name++; 
				index++; 
			}
			index += 2; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			name[index_name] = linha[index];
			index_name++;
			index++;
		}
		index++;
	}
	game->name = name;

	// release_date
	char* release_date = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_release_date = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				release_date[index_release_date] = linha[index];
				index_release_date++;
				index++; 
			}
			index += 2; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			release_date[index_release_date] = linha[index];
			index_release_date++;
			index++;
		}
		index++;
	}
	game->release_date = release_date;

	// owners
	char* owners = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_owners = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				owners[index_owners] = linha[index];
				index_owners++; 
				index++; 
			}
			index += 2; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			owners[index_owners] = linha[index];
			index_owners++;
			index++;
		}
		index++;
	}
	game->owners = owners;

	// age
	char* age = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_age = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				age[index_age] = linha[index];
				index_age++; 
				index++; 
			}
			index += 2; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			age[index_age] = linha[index];
			index_age++;
			index++;
		}
		index++;
	}
	game->age = atoi(age);

	// price
	char* price = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_price = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				price[index_price] = linha[index];
				index_price++; 
				index++; 
			}
			index += 2; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			price[index_price] = linha[index];
			index_price++;
			index++;
		}
		index++;
	}
	game->price = atof(price);

	// dlcs
	char* dlcs = (char*) malloc(MAXTAM * sizeof(char*)); 
	int index_dlcs = 0;
	if(isAspas(linha[index]) == true) {
		index++;
		while((isAspas(linha[index]) == true && isVirgula(linha[index + 1]) == true) == false) { 
				dlcs[index_dlcs] = linha[index];
				index_dlcs++; 
				index++; 
			}
			index += 4; // pular ,"
	} else {
		while(isVirgula(linha[index]) == false) {
			dlcs[index_dlcs] = linha[index];
			index_dlcs++;
			index++;
		}
		index += 3;
	}
	game->dlcs = atoi(dlcs);

	// languages
	char* languages = (char*) malloc(MAXTAM * sizeof(char*));
	int index_languages = 0;
	if(linha[index - 1] == ']') {
			game->languages = (char**) malloc(MAXTAM * sizeof(char*));
	} else {
		while(linha[index] != ']') {
			languages[index_languages] = linha[index];
			index_languages++;
			index++;
		//setLanguages(parseLanguages(languages.replace("'", "").trim()));
		}
		game->languages = parseLanguages(languages);
	}

}

int isVirgula(char c) {
	return c == ',' ? true : false;
}

int isAspas(char c) {
	return c == '"' ? true : false;
}

char* excluirBN(char* id) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	for(int i = 0; i < (int)strlen(id) - 1; i++) {
			resp[i] = id[i];
	}
	return resp;
}

void imprimir(Games* game) {
	char* release_date = (char*) malloc(MAXTAM * sizeof(char*));
	char* languages = (char*) malloc(MAXTAM * sizeof(char*));
	release_date = formatReleaseDate(game->release_date);
	languages = formatLanguages(game->languages);
	printf("%d %s %s %s %d %.2f %d %s\n", game->app_id, game->name, release_date, game->owners, game->age, game->price, game->dlcs, languages);
}

char* formatReleaseDate(char* str) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	resp[0] = str[0]; resp[1] = str[1]; resp[2] = str[2];
	resp[3] = '/'; 
	resp[4] = str[strlen(str) - 4]; resp[5] = str[strlen(str) - 3]; resp[6] = str[strlen(str) - 2]; resp[7] = str[strlen(str) - 1];
	return resp; 
}

char* formatLanguages(char** arr) {
	char* resp = (char*) malloc(MAXTAM * sizeof(char*));
	int j = 0;
	resp[j] = '[';
	if(arr == NULL) {
		for(int i = 0; i < ; i++) {
			if(arr[i] != arr[(int)strlen(arr) - 1]) {
				resp[j] = arr[i]; j++;
				resp[j] = ','; j++;
				resp[j] = ' '; j++;
			} else {
				resp[j] = arr[i]; j++;
			}
		}
	}
	resp[j] = ']';
	return resp;
}

char** parseLanguages(char* str) {
	char** resp = (char**) malloc(MAXTAM * sizeof(char*));
	int contVirgulas = getNumVirgulas(str) + 1;
	for(int i = 0, j = 0; i < contVirgulas; i++, j++) {
		resp[j] = (char*) malloc(MAXTAM * sizeof(char*));
		resp[j] = str[i];
	}
	return resp;
}

int getNumVirgulas(char* str) {
	int resp = 0;
	for(int i = 0; i < (int)strlen(str); i++) {
		if(str[i] == ',') {
			resp++;
		}
	}
	return resp;
}

int main() {
	char** entrada = (char**) malloc(MAXTAM * sizeof(char*));
	int numEntrada = 0;

	do {
		entrada[numEntrada] = (char*) malloc(MAXTAM * sizeof(char*));
		entrada[numEntrada] = fgets(entrada[numEntrada], MAXTAM, stdin);
	} while(isFim(entrada[numEntrada++]) != true);	
	numEntrada--;

	Games games[numEntrada];
	for(int i = 0; i < numEntrada; i++) {
		if(games_construtor(&games[i]) == 0)
			break;
		ler(&games[i], excluirBN(entrada[i]));
		imprimir(&games[i]);
	}

	return 0;
}
