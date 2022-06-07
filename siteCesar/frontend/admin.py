from django.contrib import admin


from .models import Estacoes, Funcionarios, Reservas
# Register your models here.


@admin.register(Estacoes)
class EstacoesAdmin(admin.ModelAdmin):
    list_display = ['estacao']

@admin.register(Funcionarios)
class FuncionariosAdmin(admin.ModelAdmin):
    list_display = ('id', 'nome')

@admin.register(Reservas)
class ReservasAdmin(admin.ModelAdmin):
    list_display = ('id_estacao', 'id_funcionario', 'data', 'reserva_inicia_em', 'reserva_termina_em', 'check_in_em')
