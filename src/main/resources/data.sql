
-- Users
INSERT INTO users(id, username, password) VALUES
('1', 'david', '$2a$10$jJx/r1TV8kohq4JlYgWhbuuZPbDKmddUgKFMwnm6ziErIb6A9NJQ.'),
('2', 'hiris', '$2a$10$8oW6IJjkc/sSHNAqsRlHYuMYnODxahqweOVTYomWnl.U7sbEjEZIa');

-- Main Tasks
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('1', '1', 'Organizar documentos do escritório', 'Separar, categorizar e arquivar todos os documentos do escritório', '2025-08-22', 'PENDING', 'MEDIUM', NULL),
('2', '1', 'Preparar apresentação do projeto', 'Criar slides e revisar o conteúdo para a reunião de sexta-feira', '2025-08-17', 'IN_PROGRESS', 'HIGH', NULL),
('3', '2', 'Planejar viagem de férias', 'Escolher destino, reservar passagens e hospedagem', '2025-09-11', 'PENDING', 'MEDIUM', NULL),
('4', '2', 'Revisar código do módulo financeiro', 'Realizar code review e apontar melhorias no módulo financeiro', '2025-08-15', 'PENDING', 'HIGH', NULL),
('5', '2', 'Atualizar inventário de equipamentos', 'Listar todos os equipamentos da empresa e atualizar o sistema', '2025-08-27', 'PENDING', 'LOW', NULL);

-- Subtasks of "Organizar documentos do escritório"
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('6', '1', 'Separar documentos fiscais', 'Identificar e separar notas fiscais e recibos', '2025-08-16', 'IN_PROGRESS', 'MEDIUM', '1'),
('7', '1', 'Arquivar contratos', 'Organizar todos os contratos em pastas corretas', '2025-08-18', 'PENDING', 'MEDIUM', '1');

-- Subtasks of "Preparar apresentação do projeto"
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('8', '1', 'Criar slides de introdução', 'Fazer a primeira parte da apresentação com visão geral do projeto', '2025-08-14', 'COMPLETED', 'HIGH', '2'),
('9', '1', 'Revisar dados do relatório', 'Checar e atualizar gráficos e métricas', '2025-08-15', 'IN_PROGRESS', 'HIGH', '2'),
('10', '1', 'Adicionar conclusões e próximos passos', 'Finalizar a apresentação com as recomendações', '2025-08-16', 'PENDING', 'HIGH', '2');

-- Subtasks of "Planejar viagem de férias"
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('11', '2', 'Pesquisar destinos possíveis', 'Pesquisar opções de viagem considerando custo-benefício', '2025-08-19', 'COMPLETED', 'LOW', '3'),
('12', '2', 'Reservar hospedagem', 'Escolher e reservar hotel ou pousada', '2025-09-01', 'PENDING', 'MEDIUM', '3'),
('13', '2', 'Comprar passagens', 'Comprar passagens aéreas com melhores preços', '2025-08-28', 'PENDING', 'HIGH', '3');

-- Subtasks of "Revisar código do módulo financeiro"
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('14', '2', 'Verificar regras de negócio', 'Checar se as validações estão corretas no backend', '2025-08-13', 'IN_PROGRESS', 'HIGH', '4'),
('15', '2', 'Testar integração com API de pagamentos', 'Executar testes automatizados para confirmar funcionamento', '2025-08-14', 'PENDING', 'HIGH', '4'),
('16', '2', 'Revisar performance de queries SQL', 'Analisar lentidão e otimizar consultas', '2025-08-15', 'PENDING', 'MEDIUM', '4');

-- Subtasks of "Atualizar inventário de equipamentos"
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('17', '2', 'Checar computadores', 'Verificar todos os computadores e registrar no sistema', '2025-08-17', 'IN_PROGRESS', 'LOW', '5'),
('18', '2', 'Inventariar impressoras', 'Registrar modelos e estado das impressoras', '2025-08-20', 'PENDING', 'LOW', '5'),
('19', '2', 'Verificar periféricos', 'Checar mouses, teclados e outros acessórios', '2025-08-18', 'PENDING', 'LOW', '5');

-- More tasks
INSERT INTO task (id, user_fk, title, description, due_date, status, priority, parent_task_fk) VALUES
('20', '2', 'Organizar evento de integração', 'Planejar local, comida e atividades para equipe', '2025-09-05', 'PENDING', 'MEDIUM', NULL),
('21', '2', 'Realizar backup dos servidores', 'Efetuar backup completo e armazenar em nuvem segura', '2025-08-25', 'PENDING', 'HIGH', NULL),
('22', '2', 'Treinar novos colaboradores', 'Apresentar sistemas e processos internos', '2025-09-02', 'IN_PROGRESS', 'MEDIUM', NULL);
