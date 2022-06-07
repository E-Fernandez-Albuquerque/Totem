# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Estacoes(models.Model):
    estacao = models.CharField(primary_key=True, max_length=6)
    horario = models.CharField(max_length=19, blank=True, null=True)
    livre = models.IntegerField(blank=True, null=True)
    id_reserva = models.IntegerField(blank=True, null=True)

    class Meta:
        db_table = 'estacoes'


class Funcionarios(models.Model):
    id = models.CharField(primary_key=True, max_length=8)
    nome = models.CharField(max_length=30)
    meu_time = models.CharField(max_length=15, blank=True, null=True)

    class Meta:
        db_table = 'funcionarios'


class Reservas(models.Model):
    id_reserva = models.AutoField(primary_key=True)
    id_estacao = models.ForeignKey(Estacoes, models.DO_NOTHING, db_column='id_estacao', blank=True, null=True)
    data = models.CharField(max_length=10, blank=True, null=True)
    reserva_inicia_em = models.CharField(max_length=8, blank=True, null=True)
    reserva_termina_em = models.CharField(max_length=8, blank=True, null=True)
    check_in_em = models.CharField(max_length=19, blank=True, null=True)
    check_out_em = models.CharField(max_length=19, blank=True, null=True)
    id_funcionario = models.ForeignKey(Funcionarios, models.DO_NOTHING, db_column='id_funcionario', blank=True, null=True)

    class Meta:
        db_table = 'reservas'
